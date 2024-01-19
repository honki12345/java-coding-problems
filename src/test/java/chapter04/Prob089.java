package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob089 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        int[] array = {1, 2, 3};

        String[] array2 = {"1", "2", "3"};

        for (var s : array2) {
            System.out.println("s = " + s);
        }

        for (var i : array) {
            System.out.println("i = " + i);
        }
    }
}
