package pengfei.learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");

        ByteBuf buf = Unpooled.copiedBuffer("QAS", utf8);
        System.out.println(buf.capacity());
        System.out.println(buf.readerIndex());
        System.out.println(buf.writerIndex());
        System.out.println("==================");


        System.out.println((char)buf.readByte());
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();

        System.out.println(buf.writerIndex());
        buf.writeByte((byte) '?');

        System.out.println(buf.toString(utf8));

        System.out.println(readerIndex);
        System.out.println(buf.readerIndex());
        System.out.println(buf.readableBytes());
        System.out.println("------------------");
        System.out.println(writerIndex);
        System.out.println(buf.writerIndex());
        System.out.println(buf.writableBytes());
        System.out.println(buf.capacity());
    }
}
