package chapter05;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Prob122 {
    @Test
    void test() {

        List<Integer> list = new CopyOnWriteArrayList<>();
        Set<Integer> set = new CopyOnWriteArraySet<>();
    }
}
