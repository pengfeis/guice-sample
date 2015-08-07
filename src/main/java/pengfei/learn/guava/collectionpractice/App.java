package pengfei.learn.guava.collectionpractice;

import com.google.common.collect.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ImmutableSet<Color> colors = ImmutableSet.<Color>builder().add(new Color()).build();
        ImmutableSet<String> ch = ImmutableSet.of("a", "b", "c", "b");
        System.out.println(ch + colors.toString());

        Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
        Map<String, Map<Long, List<String>>> map2 = Maps.newHashMap();
        Lists.newLinkedList();
        Sets.newHashSet();
        ImmutableList<String> list = ImmutableList.of("b", "a");
        System.out.println(list);

    }


}

class Color {
    public Color() {
    }
}