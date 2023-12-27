package chapter02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob050 {
    public class Radius {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public final class Point {
        private final double x;
        private final double y;
        private final Radius radius;

        public Point(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Radius getRadius() {
            return radius;
        }
    }

    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point p = new Point(1.24, 4.12, r);

        System.out.println("Radius start: " + p.getRadius().getStart());
        r.setStart(5);
        System.out.println("Radius start: " + p.getRadius().getStart());
    }

    public final class Point2 {
        private final double x;
        private final double y;
        private final Radius radius;

        public Point2(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;

            Radius clone = new Radius();
            clone.setStart(radius.start);
            clone.setEnd(radius.end);

            this.radius = clone;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Radius getRadius() {
            Radius clone = new Radius();
            clone.setStart(this.radius.getStart());
            clone.setEnd(this.radius.getEnd());

            return clone;
        }
    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point2 p = new Point2(1.23, 4.12, r);
        System.out.println("Radius start: " + p.getRadius().getStart());
        p.getRadius().setStart(5);
        System.out.println("Radius start: " + p.getRadius().getStart());
    }
}
