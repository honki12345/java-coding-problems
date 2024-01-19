package chapter05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Prob116 {
    @Test
    void test() {
//        Map<K, V> mapToCopy = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> shallowCopy(Map<K, V> map) {
        var copy = new HashMap<K, V>();
        copy.putAll(map);
        return copy;
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> shallowCopy2(Map<K, V> map) {
        Set<Map.Entry<K, V>> entries = map.entrySet();
        return (HashMap<K, V>) entries.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue
                ));
    }
}
