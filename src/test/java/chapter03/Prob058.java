package chapter03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Prob058 {

    @DisplayName("")
    @Test
    void test() {
        // given // when // then
        /*String을 LocalDate로 변환하려면 DateTimeFormatter.ISO_LOCAL_DATE 패턴을 따라야한다*/
        LocalDate localDate = LocalDate.parse("2020-06-01");
        /*2020-06-01은 ISO_LOCAL_DATE인 2020-06-01이 된다*/
        String localDateAsString = localDate.toString();

        /*String을 LocalTime으로 변환하려면 DateTimeFormatter.ISO_LOCAL_TIME 패턴을 따라야한다*/
        LocalTime localTime = LocalTime.parse("12:23:44");
//        DateTimeFormatter.ISO_ZONED_DATE_TIME


        /*String을 LocalDateTime으로 변환하려면 DateTimeFormatter.ISO_LOCAL_DATE_TIME 패턴을 따라야한다*/
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        /*2020-06-01T11:20:15는 ISO_LOCAL_DATE_TIME인 2020-06-01T11:20:15가 된다*/
        String localDateTimeAsString = localDateTime.toString();

        /*ZonedDateTime으로 변환하려면 다음 코드처럼 2020-06-01T10:15:30+09:00[Asia/Tokyo]같은
         * DateTimeFormatter.ISO_ZONED_DATE_TIME 패턴을 따라야한다*/
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
        String zonedDateTimeAsString = zonedDateTime.toString();

        /*OffsetDateTime으로 변환하려면 다음 코드처럼 2007-12-03T10:15:30+01:00 같은
         * DateTimeFormatter.ISO_OFFSET_DATE_TIME 패턴을 따라야한다*/
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");

        /* OffsetTime으로 변환하려면 10:15:30+01:00 같은 DateTimeFormatter.ISO_OFFSET_TIME 패턴을 따라야한다*/
        OffsetTime offsetTime = OffsetTime.parse("10:15:30+01:00");

        /*사전에 정의된 포매터를 따르지 않는 문자열이라면 맞추형 포맷 패턴으로 정의한
         * 사용자 정의 포매터가 필요하다*/
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted = LocalDate.parse("01.06.2020", dateTimeFormatter);
        /*01.06.2020은 ISO_LOCAL_DATE인 2020-06-01이 된다*/
        String localDateAsString2 = localDateFormatted.toString();
        String localDateAsFormattedString = dateTimeFormatter.format(localDateFormatted);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTimeFormatted = LocalTime.parse("12|23|44", timeFormatter);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.parse("01.06.2020, 11:20:15",
            dateTimeFormatter1);
        /*01.06.2020, 11:20:15는 ISO_LOCAL_DATE_TIME인 2020-06-01T11:20:15가 된다*/
        String localDateTimeAsString2 = dateTimeFormatter1.toString();
        String localDateTimeAsFormattedString = dateTimeFormatter1.format(localDateTime1);

        DateTimeFormatter zonedFormatter = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse(
            "01.06.2020, 11:20:15+09:00 [Asia/Tokyo]", zonedFormatter);
        String zonedDateTimeAsFormattedString = zonedFormatter.format(zonedDateTime1);

        DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern(
            "yyyy.MM.dd, HH:mm:ss, XXXXX");
        OffsetDateTime offsetDateTime1 = OffsetDateTime.parse("2007.12.03, 10:15:30, +01:00",
            offsetFormatter);

        DateTimeFormatter offsetFormatter2 = DateTimeFormatter.ofPattern("HH mm ss XXXXX");
        OffsetTime offsetTime1 = OffsetTime.parse("10 15 30 +01:00", offsetFormatter2);

        DateTimeFormatter zonedDateTimeFormatter = DateTimeFormatter.ofPattern(
                "dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'")
            .withZone(ZoneId.of("Europe/Paris"));
        ZonedDateTime zonedDateTimeFormatted = ZonedDateTime.parse(
            "01.06.2020, 11:20:15+09:00 [Asia/Tokyo]",
            zonedDateTimeFormatter);
        System.out.println("zonedDateTimeFormatted = " + zonedDateTimeFormatted);

        String format = zonedDateTimeFormatted.format(zonedDateTimeFormatter);
        System.out.println("format = " + format);
    }

}
