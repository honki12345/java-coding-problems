package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;

public class Prob125 {
    public static <T> Map.Entry<T, T> array(
            T[] arr, Comparator<? super T> c
    ) {
        T min = arr[0];
        T max = arr[0];

        for (T elem : arr) {
            if (c.compare(min, elem) > 0) {
                min = elem;
            } else if (c.compare(max, elem) < 0) {
                max = elem;
            }
        }

        return Map.entry(min, max);
    }

    @Test
    void melon() throws Exception {
        //given //when //then
        Melon melon1 = new Melon("good", 10);
        Melon melon2 = new Melon("bad", 20);
        Melon melon3 = new Melon("not bad", 20);

        Melon[] melons = {melon1, melon2, melon3};

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Map.Entry<Melon, Melon> minmax = array(melons, byWeight);

        System.out.println("minmax.getKey() = " + minmax.getKey());
        System.out.println("minmax.getKey() = " + minmax.getKey());
    }


}
