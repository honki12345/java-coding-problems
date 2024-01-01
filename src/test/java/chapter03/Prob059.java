package chapter03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob059 {
    /*yyyy-MM-dd: 2019-02-24
    * MM-dd-yyyy 02-24-2019
    * dd-MM-yy 24-02-19
    * dd.MM.yyyy 24.04.2019
    * yyyy-MM-dd HH:mm:ss 2019-02-24 11:26:26
    * yyyy-MM-dd HH:mm:ssSSS 2019-02-24 11:36:32743
    * yyyy-MM-dd HH;mm:ssZ 2019-02-24 11:40:35+0200
    * yyyy-MM-dd Hh:mm:ss z 2019-02-24 11:45:03 EET
    * E MMM yyyy HH:mm:ss.SSSZ Sun Feb 2019 11:46:32.393+0200
    * yyyy-MM-dd HH:mm:ss VV 2019-02-45 11:45:41 Europe/Athens*/

    @DisplayName("")
    @Test
    void test() {
        /*LocalDate*/
        // given // when // then
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String StringLD = formatterLocalDate.format(localDate);

//        더 간단히
        String stringLD2 = LocalDate.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatterLocalTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String stringLT = formatterLocalTime.format(localTime);

        String stringLT2 = LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stringLDT = formatterLocalDateTime.format(localDateTime);

        String stringLDT2 = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter formatterZonedDateTime = DateTimeFormatter.ofPattern(
            "E MMM yyyy HH:mm:ss.SSSZ");
        String stringZDT = formatterZonedDateTime.format(zonedDateTime);

        String stringZDT2 = ZonedDateTime.now()
            .format(DateTimeFormatter
                .ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatterOffsetDateTime = DateTimeFormatter.ofPattern(
            "E MMM yyyy HH:mm:ss.SSSZ");
        String odt1 = formatterOffsetDateTime.format(offsetDateTime);

        String odt2 = OffsetDateTime.now()
            .format(DateTimeFormatter
                .ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));

        OffsetTime offsetTime = OffsetTime.now();
        DateTimeFormatter formatterOffsetTime = DateTimeFormatter.ofPattern("HH:mm:ss,Z");
        String ot1 = formatterOffsetTime.format(offsetTime);

        String ot2 = OffsetTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss,Z"));

        System.out.println("stringZDT2 = " + stringZDT2);
        System.out.println("odt1 = " + odt1);
        System.out.println("ot2 = " + ot2);
    }

}
