package performance;

import org.openjdk.jmh.annotations.*;
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
                .include("xxx.xxx")
                .forks(1)
                .threads(100)
                .build();

        new Runner(options).run();
    }

    @Fork(1)
    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public long rawAdd() {
        return ++origin;
    }

    @Fork(1)
    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public long syncAdd() {
        synchronized (this) {
            return ++origin;
        }
    }


    @Fork(value = 1, jvmArgsAppend = "-XX:-UseBiasedLocking")
    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public long casAdd() {
        return al.decrementAndGet();
    }


}
