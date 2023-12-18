package chapter01;

// 문자열에서 여백 제거
public class Prob008 {
    /* String.replaceAll() 메서드와 \s 정규식으로 문제를 해결할 수 있다
    * \s는 \t, \n, \r처럼 보이지 않는 여백을 포함해 모든 여백을 제거한다*/
    public static String removeWhitespaces(String str) {
        return str.replaceAll("\\s", "");
    }

    /*JDK 11부터는 String.isBlank()을 사용해
    * 문자열이 비었는지 혹은 여백 코드 포인트만 포함하는지 검사할 수 있다*/

}
