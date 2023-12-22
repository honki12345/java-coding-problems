package chapter01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 012 중복 문자 제거
public class Prob012 {

    /*StringBuilder를 사용하는 해법
     * 주어진 문자열의 문자를 순회하면서 고유한 문자를 포함하는 새 문자열을 구성
     * 자바에서 문자열은 불변이므로 주어진 문자열에서 그냥 문자를 제거할 수 없다*/
    public static String removeDuplicates(String str) {
        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : chArray) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    /*HashSet과 StringBuilder를 사용한 해법*/
    public static String removeDuplicates2(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();

        for (char c : charArray) {
            if (chHashSet.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /*자바8 함수형 스타일*/
    public static String removeDuplicates3(String str) {
        return Arrays.stream(str.split(""))
            .distinct()
            .collect(Collectors.joining());
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        String str = "abcde";
        String[] expected = new String[]{"a", "b", "c", "d", "e"};

        // when
        String[] splitedString = str.split("");

        // then
        Assertions.assertEquals(splitedString.length, 5);
        Assertions.assertArrayEquals(expected, splitedString);
    }


}
