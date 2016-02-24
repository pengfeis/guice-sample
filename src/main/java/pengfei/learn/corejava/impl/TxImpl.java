package pengfei.learn.corejava.impl;

import pengfei.learn.corejava.Tx;

public class TxImpl implements Tx{

    @Override
    public void doSomeThing() {
        System.out.println("I am doing something....");
    }
}
