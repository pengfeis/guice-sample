package pengfei.learn.corejava.gof.singleton;

/**
 * @author pengfeisu
 */
public class SafeDoubleCheckedLocking {

    /**
     * volatile field stop the compiling re-order
     */
    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (Instance.class) {
                //instance为volatile，现在没问题了
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }


    private static class Instance {
        private Instance() {
        }
    }

}
