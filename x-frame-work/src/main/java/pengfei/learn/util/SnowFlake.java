//package pengfei.learn.util;
//
///**
// * snowflake算法的id生成器
// *
// * @author supengfei
// */
//public enum SnowFlake {
//
//    /**
//     * <b>effective java</b>
//     * <br/>
//     * item 3: Enforce the singleton property with a private constructor or enum type
//     */
//    INSTANCE;
//
//    /**
//     * start timestamp 2108-01-32 17:22:22
//     */
//    private static final long EPOCH = 1517390542000L;
//
//
//    private static final long WORKER_BITS = 10L;
//    /**
//     * sequence bits
//     */
//    private static final long SEQ_BITS = 12L;
//
//    /**
//     * timestamp mask
//     */
//    private static final long TS_SHIFT = SEQ_BITS + WORKER_BITS;
//
//    /**
//     * sequence mask
//     */
//    private static final long SEQ_MASK = (1 << SEQ_BITS) - 1;
//
//    /**
//     * worker id mask
//     */
//    private static final long WORKER_SHIFT = SEQ_BITS;
//
//    /**
//     * sequence id
//     */
//    private volatile long seq = 0L;
//
//    private long workerId = WorkerUtils.getId();
//
//    /**
//     * last timestamp
//     */
//    private volatile long lstTs = -1;
//
//    public synchronized long next() {
//        long now = System.currentTimeMillis();
//        if (lstTs == now) {
//            seq = (seq + 1) & SEQ_MASK;
//            if (seq == 0) {
//                now = untilNextMilli(lstTs);
//            }
//        } else {
//            seq = 0L;
//        }
//        lstTs = now;
//        return ((now - EPOCH) << TS_SHIFT) | (workerId << WORKER_SHIFT) | seq;
//    }
//
//    /**
//     * spin until next millis
//     *
//     * @param lastTime last time
//     * @return next time millis
//     */
//    private long untilNextMilli(long lastTime) {
//        long now = System.currentTimeMillis();
//        while (now <= lastTime) {
//            now = System.currentTimeMillis();
//        }
//        return now;
//    }
//}