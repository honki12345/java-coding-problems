package chapter05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Prob120 {
    @Test
    void test() {
        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon("Apollo", 3000));
        melons.add(new Melon("Jade Dew", 3500));
        melons.add(new Melon("Cantaloupe", 1500));
        melons.add(new Melon("Gac", 1600));
        melons.add(new Melon("Hami", 1400));

        List<String> melonsByType = Arrays.asList("Apollo", "Gac", "Crenshaw", "Hami");

        List<Melon> results = melons.stream()
                .filter(t -> melonsByType.contains(t.getType()))
                .collect(Collectors.toList());

        /*Set은 대개 Map 으로 구현하고
        * Set 에 들어가는 각 원소는 element-PRESENT 타입의 키-값으로 매핑된다
        * 따라서 element 는 map의 키이고 PRESENT는 의미없는 더미값이다*/

        Set<String> melonsSetByType = melonsByType.stream()
                .collect(Collectors.toSet());

/*
        list<melon> results = melons.stream()
                .filter(t -> melonssetbytype.contains(t.gettype()))
                .collectlect(collectors.tolist());
*/
    }
}
