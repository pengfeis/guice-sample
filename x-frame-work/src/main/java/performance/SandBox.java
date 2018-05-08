package performance;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author pengfeisu
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@State(Scope.Benchmark)
public class SandBox {

    Object lock = new Object();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(SandBox.class.getSimpleName())
                .jvmArgs("-ea", "-Xms1g", "-Xmx1g")
                .shouldFailOnError(true)
                .build();
        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class Holder {

        private long number;

        private AtomicLong atomicLong;

        @Setup
        public void setUp() {
            number = ThreadLocalRandom.current().nextLong();
            atomicLong = new AtomicLong(number);
        }
    }

    @Fork(1)
    @Benchmark
    public long sync(Holder holder) {
        long n = holder.number;
        synchronized (lock) {
            n = n * 123;
        }

        return n;
    }

    @Fork(1)
    @Benchmark
    public AtomicLong cas(Holder holder) {
        AtomicLong al = holder.atomicLong;
        al.updateAndGet(x -> x * 123);
        return al;
    }

    private Object anotherLock = new Object();

    private long anotherNumber = ThreadLocalRandom.current().nextLong();

    private AtomicLong anotherAl = new AtomicLong(anotherNumber);

    @Fork(1)
    @Benchmark
    public long syncShared() {
        synchronized (anotherLock) {
            anotherNumber = anotherNumber * 123;
        }

        return anotherNumber;
    }

    @Fork(1)
    @Benchmark
    public AtomicLong casShared() {
        anotherAl.updateAndGet(x -> x * 123);
        return anotherAl;
    }

    @Fork(value = 1, jvmArgsAppend = "-XX:-UseBiasedLocking")
    @Benchmark
    public long syncSharedNonBiased() {
        synchronized (anotherLock) {
            anotherNumber = anotherNumber * 123;
        }

        return anotherNumber;
    }

}
