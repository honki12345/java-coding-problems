package chapter01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Prob040 {

    public static List<Integer> evenIntegers(List<Integer> integers) {
        if (integers == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> evens = new ArrayList<>();
        for (Integer nr : integers) {
            if (nr != null && (nr & 2) == 0) {
                evens.add(nr);
            }
        }

        return evens;
    }


}
