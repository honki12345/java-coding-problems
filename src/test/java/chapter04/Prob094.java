package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Prob094 {
    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then

        float ratio = fetchRatio();

        var weighter = new Weighter2() {
            @Override
            public float getMarginOfError() {
                return 0;
            }
        };

        ratio = fetchRatio();


    }

    public float fetchRatio() {
        final float limit = new Random().nextFloat();
        final float bmi = 0.00023f;

        return limit * bmi / 100.12f;

    }
}
