package pengfei.learn.guice.services;

import javax.inject.Singleton;

/**
 * Created by pengfei on 2014/7/31.
 */
public class EmailService implements MsgService {
    @Override
    public boolean sendMsg(String msg, String recipient) {
        System.out.println("Email sending to " + recipient + "with msg: " + msg);
        return true;
    }
}
