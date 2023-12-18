package chapter01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 모든 순열 생성
public class Prob010 {
    /* TODO 재귀는 어떤 시작 상태(initial state)가 주어지고
     * 앞선 상태에 따라 각 연속된 상태(successive state)를 정의하는 하나의 프로세스로 정의된다*/

    /* 모든 순열을 생성하는 문제에서는 주어진 문자열의 글자들로 상태를 나타낼 수 있다
     * 시작 상태는 최초의 문자열을 포함하며
     * 연속된 각 상태는 다음 공식으로 계산한다
     *
     * 문자열의 각 글자가 그 문자열의 첫번째 글자가 되고(위치를 바꾼다)
     * 재귀 호출로 나머지 글자들을 뒤바꾼다*/
    public static void permuteAndPrint(String str) {
        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String string) {
        int n = string.length();

        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                // TODO 테스트해봄
                permuteAndPrint(prefix + string.charAt(i),
//                    string.substring(i + 1, n) + string.substring(0, i));
                    string.substring(0, i) + string.substring(i + 1, n));
            }
        }
    }

    @Test
    void test() {
//        permuteAndPrint("ABC");
        permuteAndPrint("TEST");

        String orderString = "TEST TETS TSTE TSET TTES TTSE ESTT ESTT ETTS ETST ETST ETTS STTE STET STET STTE SETT SETT TTES TTSE TEST TETS TSTE TSET";
        String reverseOrderString = "TEST TETS TSET TSTE TTES TTSE ETST ETTS ESTT ESTT ETTS ETST STET STTE SETT SETT STTE STET TTES TTSE TETS TEST TSTE TSET";
        List<String> strList = List.of(orderString.split(" "));
        List<String> reverseStrList = List.of(reverseOrderString.split(" "));
        for (String str :
            strList) {
            if (!reverseStrList.contains(str)) {
                throw new RuntimeException();
            }
        }
    }

    /*결과를 저장하고 싶으면 구현에 Set을 추가해야 한다
     * 중복을 제거해주므로 Set을 쓰는 편이 좋다*/
    public static Set<String> permuteAndStore(String str) {
        return permuteAndStore("", str);
    }

    public static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                /* TODO 위 아래 Set 에 추가하는 로직이 중복된다*/
                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
                    str.substring(i + 1, n) + str.substring(0, i)));
            }
        }

        return permutations;
    }

    /*함수형스타일*/
    private static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            /* IntStream.range(int startInclusive, int endExclusive)
            Returns a sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.*/
            /*TODO 신기한 코드 - for문 대신 IntStream.range로 이렇게 할 수 있구나
            *  그것도 parallel()로*/
            /*TODO 참조: 테스트코드에서는 병렬 실행을 기다려주지 않고 끝난다*/
            IntStream.range(0, n)
                .parallel()
                .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                    str.substring(i + 1, n) + str.substring(0, i)));
        }
    }

    public static void permuteAndPrintStream(String str) {
        permuteAndPrintStream("", str);
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        permuteAndPrintStream("ABCDE");
    }
}
