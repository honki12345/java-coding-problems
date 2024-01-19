package chapter05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Prob121 {
    @Test
    void test() {
        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon("Apollo", 3000));
        melons.add(new Melon("Jade Dew", 3500));
        melons.add(new Melon("Cantaloupe", 1500));
        melons.add(new Melon("Gac", 1600));
        melons.add(new Melon("Hami", 1400));

        for (int i = 0; i < melons.size(); i++) {
            if (melons.get(i).getWeight() < 3000) {
                melons.set(i, new Melon(melons.get(i).getType(), 3000));
            }
        }

        UnaryOperator<Melon> operator = t -> (t.getWeight() < 3000) ? new Melon(t.getType(), 3000) : t;
        melons.replaceAll(operator);
    }
}
