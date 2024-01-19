package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob093 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        var weighter = new Weighter() {
            @Override
            public int getWeight(Player player) {
                return 0;
            }
        };
        Player player = new Player();
        int weight = weighter.getWeight(player);
    }
}
