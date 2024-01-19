package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Prob096 {
    @DisplayName("")
    @Test
    void test() {
//        var message = null;
//        var message;

/*
        try (PrintWriter writer = new PrintWriter("welcome.txt")) {
            writer.println("Welcome message");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
*/

        try (var writer = new PrintWriter("welcome.txt")) {
            writer.println("hi");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
