package chapter05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Prob101 {
    @Test
    void test() {
        int[] integers1 = {3, 4, 5, 6, 1, 5};
        int[] integers2 = {3, 4, 5, 6, 1, 5};
        int[] integers3 = {3, 4, 5, 6, 1, 3};

        boolean equals1 = Arrays.equals(integers1, integers2);
        boolean equals2 = Arrays.equals(integers1, integers3);
        Assertions.assertTrue(equals1);
        Assertions.assertFalse(equals2);

        Assertions.assertEquals(-1, Arrays.mismatch(integers1, integers2));
        Assertions.assertEquals(5, Arrays.mismatch(integers1, integers3));
    }

    @Test
    void test2() {
        Melon[] melons1 = {new Melon("Crenshaw", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};
        Melon[] melons2 = {new Melon("Crenshaw", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};
        Melon[] melons3 = {new Melon("Hami", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};

        Assertions.assertTrue(Arrays.equals(melons1, melons2));
        Assertions.assertFalse(Arrays.equals(melons1, melons3));

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        Assertions.assertTrue(Arrays.equals(melons1, melons3, byWeight));
        Assertions.assertFalse(Arrays.equals(melons1, melons3, byType));

        Assertions.assertEquals(-1, Arrays.mismatch(melons1, melons2));
        Assertions.assertEquals(0, Arrays.mismatch(melons1, melons3));

        Assertions.assertEquals(-1, Arrays.mismatch(melons1, 1, 2, melons3, 1, 2));
        Assertions.assertEquals(-1, Arrays.mismatch(melons1, melons3, byWeight));

        Assertions.assertEquals(0, Arrays.mismatch(melons1, melons3, byType));
    }
}
