package pengfei.learn.corejava.ih;

import org.junit.Test;
import pengfei.learn.corejava.Logging;
import pengfei.learn.corejava.impl.LoggingImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class LoggingIHTest {

    @Test
    public void testInvoke() throws Exception {
        Logging logging = new LoggingImpl();
        InvocationHandler ih = new LoggingIH(logging);
        Class<? extends Logging> cls = logging.getClass();
        Logging instance = (Logging) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ih);
        instance.printLog("Hello World");
    }
}