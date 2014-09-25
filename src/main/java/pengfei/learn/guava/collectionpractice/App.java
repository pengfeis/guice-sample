package pengfei.learn.guava.collectionpractice;

import com.google.common.collect.ImmutableSet;

/**
 * Created by pengfei on 2014/9/25.
 */
public class App {
    public static void main(String[] args) {
        ImmutableSet<Color> colors = ImmutableSet.<Color>builder().add(new Color()).build();
        ImmutableSet<String> ch = ImmutableSet.of("a", "b", "c", "b");
        System.out.println(ch + colors.toString());
    }


}

class Color {
    public Color() {
    }
}