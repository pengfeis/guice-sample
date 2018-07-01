package pengfei.learn.util.impl;

import pengfei.learn.util.IdGenerator;

/**
 * snow flake algo id generator
 */
public class SfIdGenerator implements IdGenerator {
    /**
     * start timestamp 2108-01-32 17:22:22
     */
    private final long EPOCH = 1517390542000L;

    private long LST_TS = -1;

    private long WORKER_ID = 10L;

    @Override
    public String next() {
        return null;
    }
}
