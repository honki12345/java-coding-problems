package chapter01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

// 002 반복되지 않은 첫번째 문자 찾기
public class Prob002 {

    // 한 번 순회하는 방식: 배열을 생성해 문자열에서 한번만 나오는 문자들의 인덱스를 저장한다
    // 이후 반복되지 않은 문자들을 포함하는 이 배열에서 가장 작은 인덱스를 반환한다
    private static final int EXTENDED_ASCII_CODES = 256;

    /* 이 해법은 문자열 내 모든 문자가 확장 아스키표에 속한다고 가정한다
    * 256보다 코드가 크면 그에 맞게 배열의 크기를 늘려야한다
    * 이 해법은 배열 크기가 char 타입의 최댓값, Character.MAX_VALUE를 넘지않는한 잘 동작한다
    * 이 범위를 넘어서는 즉 유니코드일시 codePointAt(), codePoints()에 기반한 구현이 필요하다*/
    public char firstNonRepeatedCharacter(String str) {
        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ?
            Character.MIN_VALUE : str.charAt(position);
    }

    /*LinkedHashMap을 활용한 해법
    * LinkedHashMap 는 삽입 순서를 유지하는(insertion-order) 맵이다(맵에 삽입한 순서대로 키를 유지한다)
    * LinkedHashMap은 문자를 키로, 빈도수를 값으로 해서 든다*/
    public char firstNonRepeatedCharacter2(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        // for(char ch: str.toCharArray()) {...}를 사용해도 된다
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Entry<Character, Integer> entry :
            chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    /*자바8 함수형 스타일: 아스키, 16비트 유니코드, 유니코드 대리쌍을 지원하는 해법*/
    public static String firstNonRepeatedCharacter3(String str) {
        // mapToOjb: int 에서 Integer로 변환  여기서는 IntStream.boxed()로 해결가능
        Map<Integer, Long> chs = str.codePoints()
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
            .filter(e -> e.getValue() == 1L)
            .findFirst()
            .map(Map.Entry::getKey)
            .orElse(Integer.valueOf(Character.MIN_VALUE));

        // String.valueOf(Character.toChars(int codePoint))
        return String.valueOf(Character.toChars(cp));
    }

}
