package chapter01;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 011 문자열 회문 검사
public class Prob011 {

    /*중간에서 만나는 방식(meet-in-the-middle)으로 주어진 문자열들의 글자를 비교
     * 문자열 중간에 도달할 때까지 첫번째 문자와 마지막 문자, 두번째 문자와 끝에서 두번째 문자등을 비교한다*/
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*for문 버전*/
    public static boolean isPalindrome2(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /*StrinbBuilder 클래스 활용*/
    public static boolean isPalindrome3(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }


    /*함수형 스타일*/
    public static boolean isPalindrome4(String str) {
        return IntStream.range(0, str.length() / 2)
            .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

    public static boolean isPalindrome5(String str) {
        return IntStream.range(0, str.length() / 2)
            .allMatch(p -> str.charAt(p) == str.charAt(str.length() - p - 1));
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        String true1 = "kayak";
        String true2 = "deified";
        String false1 = "hi";
        String false2 = "hello";

        // when // then
        Assertions.assertTrue(isPalindrome5(true1));
        Assertions.assertTrue(isPalindrome5(true2));
        Assertions.assertFalse(isPalindrome5(false1));
        Assertions.assertFalse(isPalindrome5(false2));
    }
}
