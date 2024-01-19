package chapter05;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Prob110 {
    @Test
    void test() {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "127.0.0.1:5432");
        map.put("mysql", "192.168.0.50:3306");
        map.put("cassandra", "192.168.1.5:9042");

        String derby = map.get("derby");
        String hp1 = map.getOrDefault("derby", "69:89:31.226:27017");
        String hp2 = map.getOrDefault("mysql", "69:89:31.226:27017");
        System.out.println("hp1 = " + hp1);
        System.out.println("hp2 = " + hp2);
    }

    @Test
    void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "127.0.0.1:5432");
        map.put("mysql", "192.168.0.50:3306");

        BiFunction<String, String, String> jdbcUrl = (k, v) -> String.format("jdbc:%s://%s/customers_db", k, v);
        String mysqlUrl = map.computeIfPresent("mysql", jdbcUrl);
        System.out.println("mysqlUrl = " + mysqlUrl);
        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));

        String voltdb = map.computeIfPresent("voltdb", jdbcUrl);
        System.out.println("voltdb = " + voltdb);
    }

    @Test
    void test3() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "127.0.0.1:5432");
        map.put("mysql", "192.168.0.50:3306");

        final String address = InetAddress.getLocalHost().getHostAddress();

        Function<String, String> jdbcUrl = k -> String.format("%s://%s/customer.db", k, address);

        String mongodb = map.computeIfAbsent("mongodb", jdbcUrl);
        System.out.println("mongodb = " + mongodb);
    }

    @Test
    void test4() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "127.0.0.1:5432");
        map.put("mysql", "192.168.0.50:3306");

        final String address = InetAddress.getLocalHost().getHostAddress();
        BiFunction<String, String, String> jdbcUrl = (k, v)
                -> String.format("jdbc:%s://%s/customer_db", k, ((v == null) ? address : v));

        String mysql = map.compute("mysql", jdbcUrl);
        System.out.println("mysql = " + mysql);

        String derby = map.compute("derby", jdbcUrl);
        System.out.println("derby = " + derby);
        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
    }

    @Test
    void test5() {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "9.6.1 ");
        map.put("mysql", "5.1 5.2 5.6 ");

        BiFunction<String, String, String> jdbcUrl = String::concat;
        String mysql = map.merge("mysql", "8.0 ", jdbcUrl);
        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
        System.out.println();


        String mysql2 = map.merge("mysql", "9.0 ", jdbcUrl);
        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
        System.out.println();

        String derby = map.merge("derby", "10.11.1.1 ", jdbcUrl);
        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));

    }

    @Test
    void test6() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "postgresql");
        map.put(2, "mysql");
        map.put(3, null);

        String v1 = map.putIfAbsent(1, "derby");
        String v2 = map.putIfAbsent(3, "derby");
        String v3 = map.putIfAbsent(4, "cassandra");

        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));
    }

    @Test
    void test7() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "postgresql");
        map.put(2, "mysql");
        map.put(3, "derby");

        String r1 = map.remove(1);
        System.out.println("r1 = " + r1);
        String remove = map.remove(4);
        System.out.println("remove = " + remove);

        map.forEach((s, s2) -> System.out.printf("%s : %s%n", s, s2));

        boolean r3 = map.remove(2, "mysql");
        System.out.println("r1 = " + r3);
        boolean r2 = map.remove(3, "mysql");
        System.out.println("r2 = " + r2);

        map.entrySet().removeIf(e -> e.getValue().equals("mysql"));
    }
}

