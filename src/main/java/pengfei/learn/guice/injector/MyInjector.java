package pengfei.learn.guice.injector;

import com.google.inject.AbstractModule;
import pengfei.learn.guice.services.EmailService;
import pengfei.learn.guice.services.MsgService;
import pengfei.learn.guice.services.WeiboService;

/**
 * Created by pengfei on 2014/7/31.
 */
public class MyInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(MsgService.class).annotatedWith(Weibo.class).to(WeiboService.class);
        bind(MsgService.class).to(WeiboService.class);
    }
}
