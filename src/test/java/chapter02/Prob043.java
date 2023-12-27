package chapter02;

import java.awt.Color;
import java.util.Objects;

public class Prob043 {

    public class Car {
        private final String name;
        private final Color color;

        public Car(String name, Color color) {
            if (name == null) {
                this.name = "No name";
            } else {
                this.name = name;
            }

            if (color == null) {
                this.color = new Color(0, 0, 0);
            } else {
                this.color = color;
            }
        }
    }

    public class Car2 {
        private final String name;
        private final Color color;

        public Car2(String name, Color color) {
            this.name = Objects.requireNonNullElse(name, "No name");
            this.color = Objects.requireNonNullElseGet(color, () -> new Color(0, 0, 0));
        }
    }
}
