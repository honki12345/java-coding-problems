package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class Prob107 {
    @Test
    void test() {
        int[] integers = {1, 2, 3, 4, 12, 2, 1, 4};

        int[] nge = fetch(integers);
        System.out.println("Arrays.toString(nge) = " + Arrays.toString(nge));

        println(integers);

    }

    public static void println(int[] arr) {
        int nge;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            nge = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge = arr[j];
                    break;
                }
            }
            System.out.printf("%d : %d%n", arr[i], nge);
        }

    }

    public static int[] fetch(int[] arr) {
        int n = arr.length;
        var stack = new Stack<Integer>();
        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nge;
    }
}
