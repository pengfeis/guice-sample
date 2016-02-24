package pengfei.learn.corejava.ih;

import org.junit.Test;
import pengfei.learn.corejava.Logging;
import pengfei.learn.corejava.Tx;
import pengfei.learn.corejava.impl.LoggingImpl;
import pengfei.learn.corejava.impl.TxImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class LoggingIHTest {

    @Test
    public void testInvoke() throws Exception {

        Tx tx = new TxImpl();
        InvocationHandler invocationHandler = new LoggingIH(tx);
        Tx o = (Tx)Proxy.newProxyInstance(tx.getClass().getClassLoader(), tx.getClass().getInterfaces(), invocationHandler);
        o.doSomeThing();

    }
}