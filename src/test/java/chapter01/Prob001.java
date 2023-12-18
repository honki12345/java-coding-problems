package chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 문자 개수 세기
public class Prob001 {
    public Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();

        // for(char ch: str.toCharArray()) {...}을 사용해도 된다
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    @DisplayName("compute 메서드에서 null로 매핑하면 map 에 저장되지 않는다")
    @Test
    void computeTest() {
        // Given
        Map<Character, Integer> map = new HashMap<>();
        String str = "test";

        // When
        for (char ch :
                str.toCharArray()) {
            map.compute(ch, (k, v) -> (v == null) ? null : 1);
        }

        // Then
        Assertions.assertEquals(map.size(), 0);
    }

    /* 처음 두 단계에서는 주어진 문자열을 Stream<Character>로 변환하고,
     * 나머지 한 단계에서는 문자를 분류하고 센다
     *
     * 1. 원래 문자열에 String.chars() 메서드를 호출한다. 이 메서드는 IntStream을 반환한다
     * IntStream은 주어진 무낮열 내 문자를 정수로 표현한다
     * 2. mapToObj() 메서드로 IntStream을 문자 스트림으로 변환한다(이 메서드는 정수표현을 사람이 읽기 쉬운 문자 형태로 변환한다)
     * 3. 끝으로 문자를 분류하고(Collectors.groupingBy()) 센다(collectors.counting())*/
    public Map<Character, Long> countDuplicateCharacters2(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    public Map<String, Long> countDuplicateCharacters22(String str) {
        // 유니코드 대리쌍 처리용
        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    @Test
    void test() {
        char[] chars = Character.toChars(128149);
        String str = String.valueOf(Character.toChars(128149));
        System.out.println(str);

        int lengthOfString = str.length();
        Assertions.assertEquals(lengthOfString, 2);
        int lengthOfCodePoint = str.codePointCount(0, str.length());
        Assertions.assertEquals(lengthOfCodePoint, 1);

        int i = str.codePointAt(0);
        System.out.println(i);
        int i1 = str.codePointAt(1);
        System.out.println("i1 = " + i1);
        String ch = String.valueOf(Character.toChars(i1));
        System.out.println(ch);
    }

    public static Map<String, Integer> countDuplicateCharacters333(String str) {
        Map<String, Integer> result = new HashMap<>();

        /*If the char value specified at the given index is in the high-surrogate range,
        the following index is less than the length of this String, and the char value at the following index is in the low-surrogate range,
        then the supplementary code point corresponding to this surrogate pair is returned.
        Otherwise, the char value at the given index is returned.*/
        for (int i = 0; i < str.length(); i++) {
/*
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) {
                i++;
            }
*/

            // If the specified code point is a supplementary code point, the resulting char array has the corresponding surrogate pair.
            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            // String index 로 값을 접근
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                i++;
            }

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
}
