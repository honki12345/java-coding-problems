package chapter01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 문자열 내 부분 문자열 빈도수 세기
public class Prob017 {

    public static int countStringInString(String string, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = string.indexOf(toFind, position)) != -1) {
            position += n;
            count++;
        }

        return count;
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        String str = "111";

        // when // then
        Assertions.assertEquals(countStringInString(str, "11"), 1);
    }

    public static int countStringInString2(String string, String toFind) {
        int result = string.split(Pattern.quote(toFind), -1).length - 1;

        return Math.max(result, 0);
    }

    public static int countStringInString3(String string, String toFind) {
        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;

        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }


    @DisplayName("")
    @Test
    void test3() {
        // given
        String delimiter = "i";
        String str = "--hi-i'm-fine-thank-you-and-you-ii-";

        // when
        String[] splitAsLimitZero = str.split(Pattern.quote(delimiter), 0);
        String[] splitAsMinusOne = str.split(Pattern.quote(delimiter), -1);

        // then
        System.out.println(splitAsLimitZero.length);
        System.out.println(Arrays.toString(splitAsLimitZero));
        System.out.println(splitAsMinusOne.length);
        System.out.println(Arrays.toString(splitAsMinusOne));
    }

    @DisplayName("")
    @Test
    void test4() {
        // given
        String delimiter = "abc";
        String str = "abceabceabcabcabcabc";

        // when
        String[] splitAsLimitZero = str.split(Pattern.quote(delimiter), 0);
        String[] splitAsMinusOne = str.split(Pattern.quote(delimiter), -1);

        // then
        System.out.println(splitAsLimitZero.length);
        System.out.println(Arrays.toString(splitAsLimitZero));
        System.out.println(splitAsMinusOne.length);
        System.out.println(Arrays.toString(splitAsMinusOne));
    }
}
