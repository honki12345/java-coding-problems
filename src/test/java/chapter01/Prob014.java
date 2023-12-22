package chapter01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// 빈도수가 가장 높은 문자 찾기
public class Prob014 {

    /*HashMap 활용하기*/
    public static Pair<Character, Integer> maxOccurrenceCharacter(String str) {
        Map<Character, Integer> counter = new HashMap<>();
        char[] chStr = str.toCharArray();

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) {   // 여백은 제외
                Integer noCh = counter.get(currentCh);
                if (noCh == null) {
                    counter.put(currentCh, 1);
                } else {
                    counter.put(currentCh, ++noCh);
                }
            }
        }

        int maxOccurrences = Collections.max(counter.values());
        char maxCharacter = Character.MIN_VALUE;

        for (Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getKey() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return Pair.of(maxCharacter, maxOccurrences);
    }

    /*아스키코드를 이용하는 방법*/
    private static final int EXTENDED_ASCII_CODES = 256;

    public static Pair<Character, Integer> maxOccurrenceCharacter2(String str) {
        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;
        char[] chStr = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) {
                int code = currentCh;
                asciiCodes[code]++;

                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }
        }

        return Pair.of(maxCharacter, maxOccurrences);
    }

    /*자바 8 함수형 스타일*/
    public static Pair<Character, Long> maxOccurrenceCharacter3(String str) {
        return str.chars()
            .filter(c -> Character.isWhitespace(c) == false)
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Entry.comparingByValue())
            .map(p -> Pair.of(p.getKey(), p.getValue()))
            .orElse(Pair.of(Character.MIN_VALUE, -1L));

    }
}
