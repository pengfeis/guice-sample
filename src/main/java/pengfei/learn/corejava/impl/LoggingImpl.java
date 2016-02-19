package pengfei.learn.corejava.impl;

import pengfei.learn.corejava.Logging;

/**
 * Created by pengfei on 2016/1/1.
 */
public class LoggingImpl implements Logging {
    @Override
    public void printLog(String msg) {
        System.out.println("Hello, I am printing the log " + msg);
    }
}
