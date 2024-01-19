package chapter05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Prob113 {
    @Test
    void test() {
        Map<Integer, Melon> mapOfMelon = new HashMap<>();
        mapOfMelon.put(1, new Melon("Apollo", 3000));
        mapOfMelon.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon.put(3, new Melon("Cantaloupe", 1500));

        Melon melon = mapOfMelon.replace(2, new Melon("Gac", 1000));
        mapOfMelon.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));

        boolean replace = mapOfMelon.replace(
                1, new Melon("Apollo", 3000), new Melon("Bitter", 4300)
        );
        System.out.println("replace = " + replace);
        mapOfMelon.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
    }

    @Test
    void test2() {
        Map<Integer, Melon> mapOfMelon = new HashMap<>();
        mapOfMelon.put(1, new Melon("Apollo", 3000));
        mapOfMelon.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon.put(3, new Melon("Cantaloupe", 1500));

        BiFunction<Integer, Melon, Melon> function = (k, v)
                -> v.getWeight() > 1000 ? new Melon(v.getType(), 1000) : v;
        mapOfMelon.replaceAll(function);

        mapOfMelon.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
    }
}
