package chapter01;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 003 글자와 단위 뒤집기
public class Prob003 {

    /*StringBuilder 클래스를 활용한 방법
     * 1단계: 공백을 구분자로 사용해 (String.split(" ")) 문자열을 단어 배열로 분할
     * 2단계: 해당하는 아스키코드로 각 단어를 뒤집은 후 StringBuilder에 결과를 덧붙인다*/
    private static final String WHITESPACE = " ";

    public String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reverseString = new StringBuilder();

        for (String word :
            words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reverseString.append(reverseWord).append(WHITESPACE);
        }

        return reverseString.toString();
    }

    /*자바 8 함수혈 스타일을 활용한 방법*/
    private static final Pattern PATTERN = Pattern.compile(" +");
    public static String reverseWords2(String str) {
        /*Pattern.splitAsStream: Creates a stream from the given input sequence around matches of this pattern.
        * return Stream<String>*/
        return PATTERN.splitAsStream(str)
            /* constructor method: new StringBuilder(String str)*/
            .map(w -> new StringBuilder(w).reverse())
            .collect(Collectors.joining(" "));
    }

    /*위의 두 해법은 단어 내 글자를 역순으로 뒤집지만 단어 자체의 순서는 그대로 유지한다
    * 단어의 글자 뿐만 아니라 단어의 순서도 뒤집는 메서드를 알아보자
    * StringBuilder.reverse() 메서드를 활용하면 간단하다*/
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
