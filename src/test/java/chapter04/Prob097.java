package chapter04;

import java.util.ArrayList;
import java.util.List;

public class Prob097 {
    public static <T extends Number> T add(T t) {
/*
        T tmp = t;
        return tmp;
*/

        List<T> numberList = new ArrayList<>();
        numberList.add(t);
        numberList.add((T) Integer.valueOf(3));
        numberList.add((T) Double.valueOf(3.9));
//        numberList.add("5");

        return numberList.get(0);
    }

    public static <T extends Number> T add2(T t) {
/*
        var tmp = t;
        return tmp;
*/
        var numberList = new ArrayList<T>();
        numberList.add(t);
        numberList.add((T) Integer.valueOf(3));
        numberList.add((T) Double.valueOf(3.9));

        return numberList.get(0);
    }
}
