package dates;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		LocalDateTime localDateTime2 = LocalDateTime.of(2020, 10, 1, 01, 40);
		System.out.println(localDateTime2);
		
		System.out.println(localDateTime.getHour());
		
		System.out.println(localDateTime.withDayOfMonth(22));
		
		System.out.println(localDateTime.plus(Duration.ofDays(5)));
		System.out.println(localDateTime.minusHours(1));
		
		System.out.println(localDateTime.get(ChronoField.YEAR_OF_ERA));
		
		System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
		
		 /**
         * Converting LocalDate,LocalTime to LocalDateTime and vice versa
         */
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.atTime(LocalTime.now()));
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.atDate(LocalDate.now()));
		
		System.out.println(localDateTime.toLocalDate());
		System.out.println(localDateTime.toLocalTime());
		
		// Zone
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		System.out.println(zonedDateTime.getZone());
		
		System.out.println(ZoneId.getAvailableZoneIds());
		
		System.out.println("ZoneDateTime with LocalDate and Zone ID : " + zonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Aden")));
		
		
		// get correct time in the specified zone
		System.out.println();
		System.out.println("get correct time in the specified zone");
		
		System.out.println("Zone Id with localDateTime : " + LocalDateTime.now(ZoneId.of("Asia/Aden")));
		
		System.out.println("Zone Id of ZoneDateTime : " + ZonedDateTime.now(ZoneId.of("Asia/Aden")));
		
		System.out.println("ZonedDateTime with Clock : " + ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Aden"))));
		
		LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("America/Detroit"));
        System.out.println("LocalDateTime with ZoneId Detroit : " + localDateTime1);
        
        
        // at Zone set zone for any time you want
        System.out.println();
        System.out.println("at Zone set zone for any time you want");
        
        LocalDateTime localDateTime3 = LocalDateTime.now();
		System.out.println("localDateTime atZone : " + localDateTime3.atZone(ZoneId.of("Asia/Aden")));
		
		ZonedDateTime zonedDateTime2 = localDateTime3.atZone(ZoneId.systemDefault());
		System.out.println("local Date Time to ZonedDateTime : "  + zonedDateTime2);
		
		
		ZonedDateTime zonedDateTime3 = Instant.now().atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTime3);
		
		/**
         * Convert LocalDateTime to OffsetDateTime
         */
		OffsetDateTime offsetDateTime = localDateTime3.atOffset(ZoneOffset.ofHours(-6));
		System.out.println("offsetDateTime : " + offsetDateTime);
		
		System.out.println(zonedDateTime3.toInstant().getEpochSecond());
		
		System.out.println(Instant.now().getEpochSecond());
		System.out.println(Instant.now());
		
		
		
		
		
	}
}
