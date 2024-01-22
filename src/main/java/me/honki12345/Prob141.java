package me.honki12345;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob141 {
    public static void main(String[] args) {
        Path pathArray = Paths.get("melons_array.json");
        Path pathMap = Paths.get("melons_map.json");
        Path pathRaw = Paths.get("melons_raw.json");

        try (Jsonb jsonb = JsonbBuilder.create()) {
            Melon melon = jsonb.fromJson(Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), Melon.class);
            System.out.println("melon = " + melon);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
