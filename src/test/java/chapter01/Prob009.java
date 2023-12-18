package chapter01;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

// 구분자로 여러 문자열 합치기
public class Prob009 {

    /*자바 8 이전에는 아래처럼 StringBuilder를 사용하면 좋다*/
    public static String joinByDelimiter(char delimiter, String... args) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);

        return result.toString();
    }

    /*StringJoiner 유틸리티 클래스 이용하기
     * 이 클래스는 구분자로 분리된 문자 시퀀스를 생성한다
     * 선택적으로 접두사와 접미사도 지원한다*/
    public static String joinByDelimiter2(char delimiter, String... args) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String arg :
            args) {
            joiner.add(arg);
        }

        return joiner.toString();
    }

    @Test
    void test() {
        /*String.join()을 활용하는 방법*/
        String result = String.join(" ", "how", "are", "you");
        System.out.println(result);

    }

    /*자바8 스트림과 Collectors.joining()*/
    public static String joinByDelimiter3(char delimiter, String... args) {
        return Arrays.stream(args, 0, args.length)
            .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    /*+= 연산자와 concat(), String.format()메서드로 문자열을 이어 붙일 때 주의해야한다
    * 여러 문자열을 합칠 수 있으나 성능 저하가 발생하기 쉽다
    * TODO 컴파일러가 최적화한다고 들었음*/
}