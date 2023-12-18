package chapter01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 005 모음과 자음 세기
// TODO 한글은 모음과 자음 어떻게 셀까?
public class Prob005 {

    /*문자열 내 문자를 순회하면서 다음을 수행한다
     * 1. 현재 문자가 모음인지 확인해야한다
     * 2. 현재 문자가 모음이 아니면 'a'에서 'z'사이인지 (자음인지) 확인한다
     * 우선 주어진 String 객체를 소문자로 변환해야한다. 이렇게하면 대문자와 비교하지 않아도 된다*/
    private static final Set<Character> allVowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u'));

    /* TODO Pair 사용하기
    https://stackoverflow.com/questions/5303539/didnt-java-once-have-a-pair-class
    > . With JDK 11, JavaFX being noncore module got separated from JDK so one cannot find(and yes surprised) Pair class after that.*/
    public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }

        return Pair.of(vowels, consonants);
    }

    /*chars()와 filter()를 사용해 자바8 함수형 스타일로 하기*/
    public static Pair<Long, Long> countVowelAndConsonants2(String str) {
        str = str.toLowerCase();

        // TODO 한번의 Stream API 호출로 가능하지 않을까?
        long vowels = str.chars()
            .filter(c -> allVowels.contains((char) c))
            .count();

        long consonants = str.chars()
            .filter(c -> !allVowels.contains((char) c))
            .filter(ch -> (ch >= 'a' && ch <= 'z'))
            .count();

        return Pair.of(vowels, consonants);

    }

    // TODO GPT code
    public static Pair<Long, Long> countVowelAndConsonants3(String str) {
        str = str.toLowerCase();

        long[] result = str.chars()
            .filter(ch -> (ch >= 'a' && ch <= 'z'))
            .mapToObj(ch -> (char) ch)
            .collect(() -> new long[2],
                /*
                *  R result = supplier.get();
                * for (T element : this stream)
                *      accumulator.accept(result, element);  return result;*/
                (arr, ch) -> arr[allVowels.contains(ch) ? 0 : 1]++,
                /* TODO collect operations can be parallelized without requiring additional synchronization.*/
                (arr1, arr2) -> {
                    arr1[0] += arr2[0];
                    arr1[1] += arr2[1];
                });

        return Pair.of(result[0], result[1]);
    }

    @Test
    void test() {
        // given
        String str = "abcefj";

        // when
        Pair<Long, Long> result = countVowelAndConsonants3(str);

        // then
        Assertions.assertEquals(result.getVowels(), 2);
        Assertions.assertEquals(result.getConsonants(), 4);

    }

    /*partitioningBy()를 사용하여 코드를 줄이기*/
    public static Pair<Long, Long> countVowelAndConsonants4(String str) {
        str = str.toLowerCase();

        Map<Boolean, Long> result = str.chars()
            .mapToObj(c -> (char) c)
            .filter(ch -> (ch >= 'a' && ch <= 'z'))
            .collect(Collectors.partitioningBy(c -> allVowels.contains(c), Collectors.counting()));

        return Pair.of(result.get(true), result.get(false));
    }


}
