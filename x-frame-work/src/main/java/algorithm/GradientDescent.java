package algorithm;

import com.google.common.base.Function;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class GradientDescent {
    public static void main(String[] args) {
//        ImmutableMap<Long, Long> houseSizePriceMap = new ImmutableMap.Builder<Long, Long>()
//                .put(1100L, 199000L)
//                .put(1400L, 245000L)
//                .put(1425L, 319000L)
//                .put(1550L, 240000L)
//                .put(1600L, 312000L)
//                .put(1700L, 279000L)
//                .put(1700L, 310000L)
//                .put(1875L, 308000L)
//                .put(2350L, 405000L)
//                .put(2450L, 324000L)
//                .build();

        List<Long> houseSizes = Lists.newArrayList(1100L,
                1400L,
                1425L,
                1550L,
                1600L,
                1700L,
                1700L,
                1875L,
                2350L,
                2450L);
        List<Long> housePrices = Lists.newArrayList(199000L,
                245000L,
                319000L,
                240000L,
                312000L,
                279000L,
                310000L,
                308000L,
                405000L,
                324000L);


        Ordering<Long> ordering = new Ordering<Long>() {

            @Override
            public int compare(Long left, Long right) {
                return Longs.compare(left, right);
            }
        };

        final Long maxIn = ordering.max(houseSizes);
        final Long minIn = ordering.min(houseSizes);

        final long rangeIn = maxIn - minIn;

        final Long maxOut = ordering.max(housePrices);
        final Long minOut = ordering.min(housePrices);

        final Long rangeOut = maxOut - minOut;


        List<BigDecimal> standIn = Lists.transform(houseSizes, new NormalizationFun(minIn, rangeIn));
        List<BigDecimal> standOut = Lists.transform(housePrices, new NormalizationFun(minOut, rangeOut));

        System.out.println(standIn);
        System.out.println(standOut);



        HashBasedTable<Long, Long, Long> table = HashBasedTable.create();

        table.put(1L, 1400L, 245000L);
        table.put(2L, 1425L, 319000L);
        table.put(3L, 1550L, 240000L);
        System.out.printf(table.toString());

    }

    private static class NormalizationFun implements Function<Long, BigDecimal> {
        private final Long minIn;
        private final long range;

        public NormalizationFun(Long minIn, long range) {
            this.minIn = minIn;
            this.range = range;
        }

        @Override
        public BigDecimal apply(Long input) {
            return new BigDecimal(((input - minIn) / (range * 1.0))).setScale(2, RoundingMode.CEILING);
        }
    }
}
