package pengfei.learn.corejava.gof.singleton;

public class SafeDoubleCheckedLocking {

    /**
     * volatile field stop the compiling re-order
     */
    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (Instance.class) {
                if (instance == null)
                    instance = new Instance();//instance为volatile，现在没问题了
            }
        }
        return instance;
    }


    private static class Instance {
        private Instance() {
        }
    }

}
