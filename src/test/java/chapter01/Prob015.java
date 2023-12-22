package chapter01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

// 문자열 배열을 길이 순으로 정렬
public class Prob015 {

    public static void sortArrayByLength(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs,
                (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs,
                (String s1, String s2) -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
    }

    public static void sortArrayByLength2(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
            Arrays.sort(strs,
                Comparator.comparingInt(String::length).reversed());
        }
    }

    /*자바 8 함수형 스타일*/
    public static String[] sortArrayByLength3(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toArray(String[]::new);
        }

    }
}
