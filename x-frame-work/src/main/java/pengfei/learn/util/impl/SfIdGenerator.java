package pengfei.learn.util.impl;

import pengfei.learn.util.IdGenerator;

/**
 * snow flake algo id generator
 * <br/>
 * timestamp | worker | sequence
 * <br/>
 * 41        | 10     | 12
 *
 * @author supengfei
 */
public class SfIdGenerator implements IdGenerator {

    /**
     * start timestamp 2108-01-32 17:22:22
     */
    private static final long EPOCH = 1517390542000L;


    private static final long WORKER_BITS = 10L;
    /**
     * sequence bits
     */
    private static final long SEQ_BITS = 12L;

    private static final long TS_MASK = SEQ_BITS + WORKER_BITS;

    private static final long SEQ_MASK = (1 << SEQ_BITS) - 1;
    private static final long WORKER_MASK = (1 << SEQ_BITS) - 1;

    /**
     * max sequence
     */
    private static final long maxSeq = 4096L;


    /**
     * sequence id
     */
    private volatile long seq = 0L;

    private long workerId;

    /**
     * last timestamp
     */
    private volatile long lstTs = -1;

    @Override
    public synchronized long next() {
        long now = System.currentTimeMillis();
        if (lstTs == now) {
            seq = (seq + 1) & SEQ_MASK;
            if (seq == 0) {
                now = untilNextMilli(lstTs);
            }
        } else {
            seq = 0L;
        }

        lstTs = now;
        return (now - EPOCH) << TS_MASK
                | (workerId << WORKER_MASK)
                | seq;
    }

    /**
     * spin until next millis
     *
     * @param lastTime
     * @return
     */
    private long untilNextMilli(long lastTime) {
        long now = System.currentTimeMillis();
        while (now <= lastTime) {
            now = System.currentTimeMillis();
        }
        return now;
    }
}
