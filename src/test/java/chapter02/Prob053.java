package chapter02;

import com.google.gson.Gson;
import com.rits.cloning.Cloner;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob053 {
    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        Point point = new Point(2, 3);
        Point clone = new Point(point);

    }

    @DisplayName("")
    @Test
    void test2() {
        // given // when // then
        Point point = new Point(2, 3, new Radius(4, 5));
        Cloner cloner = new Cloner();
        Point clone = cloner.deepClone(point);

        Assertions.assertEquals(clone.getRadius().getStart(), 4);
        point.getRadius().setStart(10);
        Assertions.assertEquals(point.getRadius().getStart(), 10);
        Assertions.assertEquals(clone.getRadius().getStart(), 4);
    }

    @DisplayName("")
    @Test
    void test3() {
        // given // when // then
        Point point = new Point(2, 3, new Radius(4, 5));
        Point clone = cloneThroughJson(point);

        Assertions.assertEquals(clone.getRadius().getStart(), 4);
        point.getRadius().setStart(10);
        Assertions.assertEquals(point.getRadius().getStart(), 10);
        Assertions.assertEquals(clone.getRadius().getStart(), 4);
    }
    private static <T> T cloneThroughSerialization(T t) {
/*
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);

            BufferedInputStream bais = new BufferedInputStream(baos.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(t);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            // log exception
            return t;
        }
    }

    private static <T> T cloneThroughJson(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);

        return (T) gson.fromJson(json, t.getClass());
    }

}

class Point implements Cloneable {
    private double x;
    private double y;
    private Radius radius;

    public Point() { }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point another) {
        this.x = another.x;
        this.y = another.y;
    }

    public Point(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Point clonePoint() {
        Point point = new Point();
        point.setX(this.x);
        point.setY(this.y);
        return point;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Point) super.clone();
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Radius {
    private int start;
    private int end;

    public Radius(int start, int end) {
        this.start = start;
        this.end = end;
    }

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
