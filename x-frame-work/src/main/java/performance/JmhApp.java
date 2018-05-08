package performance;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author pengfeisu
 */
@State(Scope.Benchmark)
public class JmhApp {

    private Long origin = 0L;


    private AtomicLong al = new AtomicLong(0L);


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(JmhApp.class.getSimpleName())
                .forks(1)
                .threads(200)
                .warmupIterations(1)
                .measurementIterations(2)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public long rawAdd() {
        return ++origin;
    }

    @Benchmark
    public long syncAdd() {
        synchronized (this) {
            return ++origin;
        }
    }


    @Benchmark
    public long casAdd() {
        return al.decrementAndGet();
    }


}
