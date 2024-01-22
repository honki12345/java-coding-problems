package chapter06;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import me.honki12345.Melon;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Prob141 {
    @Test
    void test() throws Exception {
        //given //when //then
        Path pathArray = Paths.get("melons_array.json");
        Path pathMap = Paths.get("melons_map.json");
        Path pathRaw = Paths.get("melons_raw.json");
        Path path = Paths.get("malons_output.json");

        try (Jsonb jsonb = JsonbBuilder.create()) {
            Melon melon = jsonb.fromJson(Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), Melon.class);
            System.out.println("melon = " + melon);
            HashMap<String, Melon> melonsMap = jsonb.fromJson(Files.newBufferedReader(pathMap, StandardCharsets.UTF_8), HashMap.class);
            System.out.println("melonsMap = " + melonsMap);

            jsonb.toJson(melonsMap, Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test2() throws Exception {
        //given //when //then
        Path pathArray = Paths.get("melons_array.json");
        Path pathMap = Paths.get("melons_map.json");
        Path pathRaw = Paths.get("melons_raw.json");
        Path path = Paths.get("malons_output.json");

        ObjectMapper mapper = new ObjectMapper();
        Melon[] melons = mapper.readValue(Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), Melon[].class);
        System.out.println("Arrays.toString(melons) = " + Arrays.toString(melons));

        List melonsList = mapper.readValue(Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), ArrayList.class);
        System.out.println("melonsList = " + melonsList);

        HashMap melonsMap = mapper.readValue(Files.newBufferedReader(pathMap, StandardCharsets.UTF_8), HashMap.class);
        System.out.println("melonsMap = " + melonsMap);

    }

    public static List<List<String>> readAsObject(Path path, Charset cs, String delimiter) throws IOException {
        List<List<String>> content = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                content.add(Arrays.asList(values));
            }
        }

        return content;
    }

    public static List<Melon> readAsMelon(Path path, Charset cs, String delimiter) throws IOException {
        List<Melon> content = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(Pattern.quote(delimiter));
                content.add(new Melon(values[0], Integer.valueOf(values[1])));
            }
        }

        return content;
    }

    @Test
    void test3() throws Exception {
        //given //when //then
        Path path = Paths.get("melon.csv");
        List<List<String>> lists = readAsObject(path, StandardCharsets.UTF_8, ",");
        System.out.println("lists = " + lists);

    }
}
