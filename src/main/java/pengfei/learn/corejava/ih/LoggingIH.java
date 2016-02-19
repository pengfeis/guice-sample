package pengfei.learn.corejava.ih;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingIH implements InvocationHandler {

    private Object target;

    public LoggingIH(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("B4 Logging");
        method.invoke(target, args);
        return null;
    }
}
