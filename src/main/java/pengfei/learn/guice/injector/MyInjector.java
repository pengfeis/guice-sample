package pengfei.learn.guice.injector;

import com.google.inject.AbstractModule;
import pengfei.learn.guice.services.EmailService;
import pengfei.learn.guice.services.MsgService;

/**
 * Created by pengfei on 2014/7/31.
 */
public class MyInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(MsgService.class).to(EmailService.class);
    }
}
