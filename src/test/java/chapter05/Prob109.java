package chapter05;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Prob109 {
    @Test
    void test() {
        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.add(6);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        List<Integer> LIST = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> LIST2 = List.of(1, 2, 3, 4, 5);
    }

    @Test
    void test2() {
        var melon1 = new MutableMelon("C", 2000);
        var melon2 = new MutableMelon("D", 2000);

        List<MutableMelon> list = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
        list.forEach(System.out::println);

        melon1.setWeight(0);
        melon2.setWeight(0);
        list.forEach(System.out::println);
    }

    @Test
    void test3() {
        List<MutableMelon> list = Collections.unmodifiableList(
                Arrays.asList(
                        new MutableMelon("C", 2000),
                        new MutableMelon("D", 2000)
                )
        );

        list.forEach(System.out::println);

        MutableMelon melon1 = list.get(0);
        MutableMelon melon2 = list.get(1);
        melon1.setWeight(0);
        melon2.setWeight(0);

        list.forEach(System.out::println);
    }

    private static final List<MutableMelon> list;

    static {
        final var melon1 = new MutableMelon("C", 2000);
        final var melon2 = new MutableMelon("D", 2000);
        list = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
    }

    @Test
    void test4() {
        final var melon1 = new ImmutableMelon("C", 2000);
        final var melon2 = new ImmutableMelon("D", 2000);
        List<ImmutableMelon> list = Collections.unmodifiableList(Arrays.asList(melon1, melon2));

        Map<String, String> key1 = Map.of("key1", "value1");
        key1.forEach((string, string2) -> System.out.printf("%s : %s%n", string, string2));

        String key11 = key1.get("key1");
        System.out.println("key11 = " + key11);
//        key1.put("key1", "value2");
    }

    @Test
    void test5() {
        Map<Integer, MutableMelon> g = Collections.singletonMap(1, new MutableMelon("G", 1200));

        Map.ofEntries(
                Map.entry(1, new MutableMelon("Apollo", 3000)),
                Map.entry(2, new MutableMelon("Jade Dew", 3500))
        );

        Map<Integer, MutableMelon> integerMutableMelonMap = Map.copyOf(g);
    }

    @Test
    void test6() {
        ImmutableArray<String> sample = ImmutableArray.from(new String[]{
                "a", "b", "c"
        });
    }
}
