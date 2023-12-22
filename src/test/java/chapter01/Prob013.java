package chapter01;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 013 주어진 문자 제거
public class Prob013 {

    /*String.replaceAll() 메서드 활용하기
     * 주어진 정규식과 일치하는 주어진 문자열의 각 부분 문자열을 주어진 대체 문자열로 대체한다*/
    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    /*정규식을 쓰지 않는 해법- StringBuilder를 활용
     * 주어진 문자열의 문자를 순회하며 각 문자와 삭제할 문자를 비교하는 방식
     * 현재 문자와 삭제할 문자가 다를 때마다 현재 문자를 StringBuilder에 이어 붙인다*/
    public static String removeCharacter2(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (c != ch) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /*자바8 함수형 스타일
     * 1. String.chars() 문자열을 IntStream으로 반환
     * 2. IntStream을 필터링해 중복을 제거한다
     * 3. 결과 IntStream을 Stream<String>으로 매핑한다
     * 4. 문자열을 조인해 하나의 문자열로 만든다*/
    public static String removeCharacter3(String str, char ch) {
        return str.chars()
            .filter(c -> c != ch)
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
    }

    /*유니코드 대리쌍 제거*/
    public static String removeCharacter4(String str, String ch) {
        int codePoint = ch.codePointAt(0);

        return str.codePoints()
            .filter(c -> c != codePoint)
            .mapToObj(c -> String.valueOf(Character.toChars(c)))
            .collect(Collectors.joining());
    }

}

