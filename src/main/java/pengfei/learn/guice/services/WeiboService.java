package pengfei.learn.guice.services;

/**
 * Created by pengfei on 2014/7/31.
 */
public class WeiboService implements MsgService {
    @Override
    public boolean sendMsg(String msg, String recipient) {
        System.out.println("This is a msg from social network to " + recipient + "with msg: " + msg);
        return true;
    }
}
