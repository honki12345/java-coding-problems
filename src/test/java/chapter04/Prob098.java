package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FilterReader;
import java.io.Reader;

public class Prob098 {
    @DisplayName("")
    @Test
    void test() {
        /*공변성(Foo<? extends T>) 반변성(Foo<? super T>)
        * 공변성에서는 Number클래스로 상한선을, 반변성에서는 FileReader 클래스로 하한선을 나타낸다*/
        Class<? extends Number> intNumber = Integer.class;
        Class<? super FilterReader> fileReader = Reader.class;


    }
}
