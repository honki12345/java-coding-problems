package chapter01;

// 004 숫자만 포함하는 문자열인지 검사
public class Prob004 {
    /*Character.isDigit() 나 String.matches() 메서드를 활용하면 된다
    * Character.isDigit() 를 활용하는 해법이 간단하고 빠르다.
    * 문자열 내 문자를 순회하다가 이 메서드에서 false를 반환하면 루프를 종료한다*/
    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /*anyMatch()를 이용하면 자바8함수형 스타일로 작성가능하다*/
    public static boolean containsOnlyDigits2(String str) {
        return !str.chars()
            /* TODO Character.isDigit(int codePoint)*/
            .anyMatch(n -> !Character.isDigit(n));
    }

    /*String.matches()를 활용하는 해법
    * 이 메서드는 문자열이 주어진 정ㄱㅍ식과 일치하는지 나타내는 boolean 값을 반환한다
    * 자바8함수형스타일과 정규식 기반 해법은 대개 느리므로 속도가 중요하다면 Character.isDigit()를 추천*/
    public static boolean containsOnlyDigits3(String str) {
        return str.matches("[0-9]+");
    }

    /*parseInt(), parseLong()으로 해결하지말자
    * TODO NumberFormatException을 잡아 catch 불록에서 비즈니스 로직을 결정하는 것은 잘못된 관례다*/

}
