package chapter02;

import java.awt.Color;
import java.util.function.Supplier;

public class Prob042 {

    public static <T> T requireNonNullElseThrowIAE(T obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }

        return obj;
    }

    public static <T> T requireNonNullElseThrowIAE(
        T obj,
        Supplier<String> messageSupplier
    ) {
        if (obj == null) {
            throw new IllegalArgumentException(messageSupplier == null
                ? null : messageSupplier.get());
        }

        return obj;
    }

    public static <T, X extends Throwable> T requireNonNullElseThrow(
        T obj,
        X exception
    ) throws X {
        if (obj == null) {
            throw exception;
        }

        return obj;
    }

    public static <T, X extends Throwable> T requireNonNullElseThrow(
        T obj, Supplier<? extends X> exceptionSupplier
    ) throws X {
        if (obj != null) {
            return obj;
        } else {
            throw exceptionSupplier.get();
        }
    }

/*
    public class Car2 {
        private final String name;
        private final Color color;

        public Car2(String name, Color color) {
            this.name = requireNonNullElseThrow(
                name,
                new UnsupportedOperationException("Name cannot be set as null")
            );
            this.color = requireNonNullElseThrow(
                color,
                () -> new UnsupportedOperationException("Color cannot be set as null")
            );
        }
    }
*/
}
