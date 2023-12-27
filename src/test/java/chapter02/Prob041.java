package chapter02;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class Prob041 {

    //    null 참조를 검사하고 맞춤형 메세지를 넣어 NullPointerException 을 던질 수 있다
    public class Car {
        private final String name;
        private final Color color;

        public Car(String name, Color color) {
            if (name == null) {
                throw new NullPointerException("Car name cannot be null");
            }

            if (color == null) {
                throw new NullPointerException("Car color cannot be null");
            }

            this.name = name;
            this.color = color;
        }

        public void assignDriver(String license, Point location) {
            if (license == null) {
                throw new NullPointerException("License cannot be null");
            }

            if (location == null) {
                throw new NullPointerException("Location cannot be null");
            }
        }
    }

    /*== 연산자와 NullPointerException 클래스를 직접 초기화하는 방식
    * Objects.requireNonNull()이라는 메서드에 숨겨졌다*/

    /*Objects.requireNonNull()은 명싲된 참조가 null이면 제공받은 메시지로
    * NullPointerException 을 던진다. null이 아니면 검사한 참조를 반환한다*/

    public class Car2 {
        private final String name;
        private final Color color;

        public Car2(String name, Color color) {
            this.name = Objects.requireNonNull(name, "Car name cannot be null");
            this.color = Objects.requireNonNull(color, "Car color cannot be null");
        }

        public void assignDriver(String license, Point location) {
            Objects.requireNonNull(license, "License cannot be null");
            Objects.requireNonNull(location, "Location cannot be null");
        }
    }
}
