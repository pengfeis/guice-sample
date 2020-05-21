/*
package algorithm;


import com.google.common.collect.PeekingIterator;

import java.util.ArrayList;
import java.util.List;

public final class DiffUtils {

    public static Difference diff(List<SomeHowVo> list1, List<SomeHowVo> list2) {

        List<SomeHowVo> both = new ArrayList();
        List<SomeHowVo> more = new ArrayList();
        List<SomeHowVo> less = new ArrayList();

        PeekingIterator<SomeHowVo> rawIt = new PeekingIterator<>(list1.iterator());
        PeekingIterator<SomeHowVo> proIt = new PeekingIterator<>(list2.iterator());
        while (rawIt.hasNext() && proIt.hasNext()) {
            SomeHowVo p1 = rawIt.peek();
            SomeHowVo p2 = proIt.peek();
            int comp = p1.compareTo(p2);
            if (comp < 0) {
                more.add(rawIt.next());
            } else if (comp > 0) {
                less.add(proIt.next());
            } else */
/* comp == 0 *//*
 {
                rawIt.next();
                proIt.next();
                both.add(p1);
            }
        }
        rawIt.forEachRemaining(less::add);
        proIt.forEachRemaining(more::add);

        return new Difference(both, more, less);
    }

}*/
