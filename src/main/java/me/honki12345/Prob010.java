package me.honki12345;

import java.util.stream.IntStream;

public class Prob010 {
    private static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            /* IntStream.range(int startInclusive, int endExclusive)
            Returns a sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.*/
            /*TODO 신기한 코드 - for문 대신 IntStream.range로 이렇게 할 수 있구나
             *  그것도 parallel()로*/
            IntStream.range(0, n)
                .parallel()
                .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                    str.substring(i + 1, n) + str.substring(0, i)));
        }
    }

    public static void permuteAndPrintStream(String str) {
        permuteAndPrintStream("", str);
    }

    public static void main(String[] args) {
        permuteAndPrintStream("ABCDE");
    }

}
