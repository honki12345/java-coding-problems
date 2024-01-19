package chapter05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Prob118 {
    @Test
    void test() {
        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon("Apollo", 3000));
        melons.add(new Melon("Apollo", 3000));
        melons.add(new Melon("Jade Dew", 3500));
        melons.add(new Melon("Cantaloupe", 1500));
        melons.add(new Melon("Gac", 1600));
        melons.add(new Melon("Hami", 1400));

        /*다수의 스레드에서 컬렉션을 수정할 때 Iterator로 삭제하면 컬렉션 타입에 따라
        * ConcurrentModificationException이 발생하기 쉽다*/

        StreamSupport.stream(melons.spliterator(), false).count();
        melons.removeIf(t -> t.getWeight() < 3000);

        /*filter()는 주어진 predicate를 만족하는 원소만 컬렉션에 남긴다*/
        melons.stream()
                .filter(t -> t.getWeight() >= 3000);

        /*프레디케이트에 따라 원소를 분류하고 싶을 때
        * 기본적으로 Collectors.partitioningBy()는 원소를 두 개의 리스트로 분리한다
        * 두 리스트는 Map의 값으로 추가된다
        * Map의 두 키는 true와 false이다*/
        Map<Boolean, List<Melon>> separatedMelons = melons.stream()
                .collect(Collectors.partitioningBy(
                        melon -> melon.getWeight() >= 3000
                ));
        List<Melon> weightLessThan3000 = separatedMelons.get(false);
        List<Melon> weightGreaterThan3000 = separatedMelons.get(true);

        int frequency = Collections.frequency(melons, melons.get(0));
        System.out.println("frequency = " + frequency);

    }
}
