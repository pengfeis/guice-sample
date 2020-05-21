package algorithm;

import java.util.List;

/**
 * @author pengfeisu
 */
public class Difference<T> {

    private List<T> both;
    private List<T> more;
    private List<T> less;


    public Difference(List<T> both, List<T> more, List<T> less) {
        this.both = both;
        this.more = more;
        this.less = less;
    }
}
