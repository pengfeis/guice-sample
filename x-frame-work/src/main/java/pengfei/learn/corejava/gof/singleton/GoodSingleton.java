package pengfei.learn.corejava.gof.singleton;

public class GoodSingleton {

    private GoodSingleton() {
    }


    private static class Holder {
        static final GoodSingleton INSTANCE = new GoodSingleton();
    }
    public static GoodSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
