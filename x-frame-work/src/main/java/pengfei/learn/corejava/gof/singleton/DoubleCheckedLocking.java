package pengfei.learn.corejava.gof.singleton;

/**
 * Created by pengfeisu on 2017/8/3.
 */
public class DoubleCheckedLocking {
    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
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
