package pengfei.learn.guava.collectionpractice;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

public class MapDiff {
    public static void main(String[] args) {
        Map<String, Long> m1 = Maps.newHashMap();
        Map<String, Long> m2 = Maps.newHashMap();

        m1.put("1", 1L);
        m1.put("2", 2L);
        m1.put("3", System.currentTimeMillis());
        m1.put("4", System.currentTimeMillis());
        m1.put("5", System.currentTimeMillis());
        m2.put("1", System.currentTimeMillis());
        m2.put("3", System.currentTimeMillis());
        m2.put("8", System.currentTimeMillis());


        MapDifference<String, Long> difference = Maps.difference(m1, m2);
        Map<String, Long> stringLongMap = difference.entriesInCommon();

        System.out.println(stringLongMap);
    }
}
