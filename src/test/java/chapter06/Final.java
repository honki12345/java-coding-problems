package chapter06;

import org.junit.jupiter.api.Test;

public class Final {
    private int instanceVariable = 1335;

    @Test
    void test() throws Exception {
        //given //when //then
        int number = 1336;
        Runnable r = () -> System.out.println(number);
        r.run();

        Runnable r2 = () -> System.out.println(instanceVariable);
        r2.run();
        instanceVariable = 322;
        r2.run();
    }
}
