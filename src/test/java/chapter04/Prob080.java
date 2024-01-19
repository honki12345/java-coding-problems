package chapter04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob080 {
    public static float fetchBestPrice(String[] products) {
        float realprice = 399.99F;
//        int price = (int) realprice;

        return realprice;
    }

    public static boolean debitCard(float amount) {
        return true;
    }

    public static boolean purchaseCard(long customerId) {
        var price = fetchBestPrice(new String[0]);
        var paid = debitCard(price);
        return paid;
    }

    @DisplayName("")
    @Test
    void test() {
        // Given // When // Then
        String[] strings = new String[0];
        System.out.println("strings.length = " + strings.length);
    }
}
