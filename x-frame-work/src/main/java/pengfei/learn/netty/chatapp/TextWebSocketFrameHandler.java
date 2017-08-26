package pengfei.learn.netty.chatapp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final ChannelGroup group;

    public TextWebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof   WebSocketServerProtocolHandler.HandshakeComplete) {
            // remove http handler if hand shake success
            ctx.pipeline().remove(RawHttpRequestHandler.class);
            // notice all client new web socket client connected
            group.writeAndFlush(new TextWebSocketFrame("client " + ctx.channel() + "joined"));
            // add to group for the new channel so that its can receive all msg.
            group.add(ctx.channel());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // add reference and write all connection client
        group.writeAndFlush(msg.retain());
    }


}
