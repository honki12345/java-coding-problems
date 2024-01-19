package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Prob085 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        int[] numbers = new int[10];
        var numberArray = new int[10];
        numberArray[0] = 3;
        System.out.println(Arrays.toString(numberArray));
    }
}
