package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Prob106 {
    @Test
    void test() {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);

        Arrays.setAll(arr, t -> {
            if (t == 0) {
                return arr[t];
            } else {
                return arr[t - 1] + 1;
            }
        });

        Arrays.parallelSetAll(arr, t -> {
            if (arr[t] % 2 == 0) {
                return arr[t] * arr[t];
            } else {
                return arr[t] - 1;
            }
        });

//        Arrays.parallelPrefix();
    }
}
