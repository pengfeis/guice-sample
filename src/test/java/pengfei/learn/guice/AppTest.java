package pengfei.learn.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import pengfei.learn.guice.customer.MyApplication;
import pengfei.learn.guice.injector.MyInjector;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple Test.
 */
public class AppTest {

    @Test
    public void testSendMsg() {
        Injector injector = Guice.createInjector(new MyInjector());
        MyApplication app = injector.getInstance(MyApplication.class);

        app.sendMsg("Hello world", "supengfei007@gmail.com");
        assertNotNull("There some instance can not be NULL", injector.getAllBindings());
    }
}
