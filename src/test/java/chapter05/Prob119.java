package chapter05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Prob119 {
    @Test
    void test() {
        List<String> names = Arrays.asList("ana", "mario", "vio");
        Object[] namesArrayAsObjects = names.toArray();

        String[] namesArrayAsStrings = names.toArray(new String[0]);
        names.toArray(String[]::new);

        /*Arrays.asList() 고정된 크기의 수정 가능한 list를 생성하는 반면,
        * of() 메서드는 배열로부터 수정 불가능한 List/Set을 생성한다b*/
    }
}
