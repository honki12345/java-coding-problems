package chapter05;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Prob115 {
    @Test
    void test() {
        Map<String, Melon> melons = new HashMap<>();
        melons.put("delicious", new Melon("Apollo", 3000));
        melons.put("belicious", new Melon("Apollo", 3000));
        melons.put("aefreshing", new Melon("Jade Dew", 3500));
        melons.put("famous", new Melon("Cantaloupe", 1500));

        TreeMap<String, Melon> sortedMap = new TreeMap<>(melons);
        sortedMap.forEach((s, melon) -> System.out.printf("%s : %s%n", s, melon));

        Comparator<String> byInt = Comparator.naturalOrder();
        Map<String, Melon> sortedMap3 = sortByKeyStream(melons, byInt);

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Map<String, Melon> sortedMap2 = sortByValueStream(melons, byWeight);

        List<String> sortedKeys = sortByKeyList(melons);
        List<Melon> sortedValues = sortByValueList(melons);
        TreeSet<String> sortedKeys2 = new TreeSet<>(melons.keySet());
        TreeSet<Melon> sortedValues2 = new TreeSet<>(melons.values());
    }

    public static <K, V> Map<K, V> sortByKeyStream(Map<K, V> map, Comparator<? super K> comparator) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static <K, V> Map<K, V> sortByValueStream(Map<K, V> map, Comparator<? super V> comparator) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));

        /*HashMap이 아니라 LinkedHashMap을 사용해야 순회 순서가 유지된다*/
    }

    public static <K extends Comparable, V> List<K> sortByKeyList(Map<K, V> map) {
        List<K> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        return list;
    }

    public static <K, V extends Comparable> List<V> sortByValueList(Map<K, V> map) {
        List<V> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }
}
