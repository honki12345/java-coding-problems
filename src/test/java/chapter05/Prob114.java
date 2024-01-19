package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob114 {
    @Test
    void test() {
        Map<Integer, Melon> mapOfMelon1 = new HashMap<>();
        mapOfMelon1.put(1, new Melon("Apollo", 3000));
        mapOfMelon1.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon1.put(3, new Melon("Cantaloupe", 1500));

        Map<Integer, Melon> mapOfMelon2 = new HashMap<>();
        mapOfMelon2.put(1, new Melon("Apollo", 3000));
        mapOfMelon2.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon2.put(3, new Melon("Cantaloupe", 1500));

        boolean equals = mapOfMelon1.equals(mapOfMelon2);
        System.out.println("equals = " + equals);
    }

    @Test
    void test2() {
        Melon[] melons1 = {
                new Melon("Apollo", 3000),
                new Melon("Jade Dew", 3500)
        };
        Melon[] melons2 = {
                new Melon("Apollo", 3000),
                new Melon("Jade Dew", 3500)
        };
        Map<Integer, Melon[]> melon1ArrayMap = new HashMap<>();
        melon1ArrayMap.put(1, melons1);


        Map<Integer, Melon[]> melon2ArrayMap = new HashMap<>();
        melon2ArrayMap.put(1, melons2);
        boolean equals = melon1ArrayMap.equals(melon2ArrayMap);
        System.out.println("equals = " + equals);
    }

    public static <A, B> boolean equalsWithArrays(Map<A, B[]> first, Map<A, B[]> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(),
                        second.get(e.getKey())));
    }
}
