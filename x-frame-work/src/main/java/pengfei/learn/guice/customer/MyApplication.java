package pengfei.learn.guice.customer;

import com.google.inject.Inject;
import pengfei.learn.guice.injector.Weibo;
import pengfei.learn.guice.services.MsgService;

/**
 * Created by pengfei on 2014/7/31.
 */
public class MyApplication {

    @Inject
    private MsgService service;

    public boolean sendMsg(String msg, String recipient) {
        return this.service.sendMsg(msg, recipient);
    }
}
