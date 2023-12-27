package chapter02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob046 {
    public class Player {
        private int id;
        private String name;

        public Player(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            final Player other = (Player) obj;

            if (this.id != other.id) {
                return false;
            }

            if (!Objects.equals(this.name, other.name)) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + this.id;
            hash = 79 * hash + Objects.hashCode(this.name);

            return hash;
        }
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        Player p1 = new Player(1, "Rafael");
        Player p2 = new Player(1, "Rafael");
        Set<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);

        // when // then
        Assertions.assertTrue(p1.equals(p2));
//        Assertions.assertTrue(players.size() == 2);
        Assertions.assertTrue(players.size() == 1);
//        Assertions.assertFalse(players.contains(new Player(1, "Rafael")));
        Assertions.assertFalse(!players.contains(new Player(1, "Rafael")));
    }

    /**/
}
