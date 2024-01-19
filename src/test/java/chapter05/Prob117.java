package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob117 {
    @Test
    void test() {
        Map<Integer, Melon> melons1 = new HashMap<>();
        melons1.put(1, new Melon("Apollo", 3000));
        melons1.put(2, new Melon("Jade Dew", 3000));
        melons1.put(3, new Melon("Cantaloupe", 1000));

        Map<Integer, Melon> melons2 = new HashMap<>();
        melons2.put(1, new Melon("Apollo", 3500));
        melons2.put(2, new Melon("Jade Dew", 3500));
        melons2.put(3, new Melon("Cantaloupe", 1500));

        mergeMaps2(melons1, melons2);
    }

    public static <K, V> Map<K, V> mergeMaps(
            Map<K, V> map1, Map<K, V> map2
    ) {
        Map<K, V> map = new HashMap<>(map1);
        map2.forEach(
                (k, v) -> map.merge(k, v, (v1, v2) -> v2)
        );

        return map;
    }

    public static <K, V> Map<K, V> mergeMaps2(
            Map<K, V> map1, Map<K, V> map2
    ) {
        Supplier<Stream <Map.Entry<K, V>>> streamSupplier
                = () -> Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        streamSupplier.get().forEach(System.out::println);
        Map<K, V> map = streamSupplier.get().collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v, v2) -> v2)
        );

        return map;
    }
}
