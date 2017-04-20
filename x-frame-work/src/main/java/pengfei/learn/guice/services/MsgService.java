package pengfei.learn.guice.services;

import com.google.inject.ImplementedBy;
import com.google.inject.name.Named;

/**
 * Created by pengfei on 2014/7/30.
 */

@ImplementedBy(EmailService.class)
public interface MsgService {
    boolean sendMsg(String msg, String recipient);
}
