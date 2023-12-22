package chapter01;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob020 {

    public static String concatRepeat(String str, int n) {
        StringBuffer sb = new StringBuffer(str.length() * n);

        for (int i = 1; i <= n; i++) {
            sb.append(str);
        }

        return sb.toString();
    }

    @DisplayName("")
    @Test
    void test() {
        // given // when // then

        Stream.generate(() -> "hi")
            .limit(5)
            .collect(Collectors.joining());

    }

    public static boolean hasOnlySubstrings(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() / 2; i++) {
            sb.append(str.charAt(i));
            String resultStr = str.replaceAll(sb.toString(), "");
            if (resultStr.length() == 0) {
                return true;
            }
        }

        return false;
    }

    @DisplayName("")
    @Test
    void test2() {
        // given
        String str = "hihihihihi";

        // when // then
        Assertions.assertTrue(hasOnlySubstrings(str));

    }

}
