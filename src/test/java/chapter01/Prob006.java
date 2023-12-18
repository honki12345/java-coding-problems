package chapter01;

// 문자 빈도수 세기
public class Prob006 {
    /*1. 주어진 문자열에서 해당 문자를 전부 ""로 치환
    * 2. 원래 문자열의 길이에서 첫번째 단계에서 얻은 문자열의 길이를 뺀다*/

    public static int countOccurrencesOfACertainCharacter(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    /*유니코드 대리쌍 까지 처리하는 코드*/
    public static int countOccurrencesOfACertainCharacter2(String str, String ch) {
        if (ch.codePointCount(0, ch.length()) > 1) {
            // TODO 주어진 문자열에 유니코드 문자가 둘 이상이면
            return -1;
        }

        int result = str.length() - str.replace(ch, "").length();

        // TODO ch.length() 가 2를 반환하면 유니코드 대리 쌍이라는 뜻
        return ch.length() == 2 ? result / 2 : result;
    }

    /*문자열 내 문자를 순회하며(한번 순회) 각 문자를 주어진 문자와 비교하는 것
    * 같을 때마다 카운터를 1 증가시킨다*/
    public static int countOccurrencesOfACertainCharacter3(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    /*함수형 스타일로 filter()와 reduce()로 해결*/
    public static long countOccurrencesOfACertainCharacter4(String str, char ch) {
        return str.chars()
            .filter(c -> c == ch)
            .count();
    }
}
