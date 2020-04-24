package dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {
	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalTime localTime2 = LocalTime.of(1, 59, 59, 59);
		System.out.println(localTime2);
		
		System.out.println(localTime.get(ChronoField.HOUR_OF_DAY));
		System.out.println(localTime.getMinute());
		System.out.println(localTime.toSecondOfDay());
		
		System.out.println(localTime.compareTo(localTime2));
		System.out.println(localTime2.compareTo(localTime));
		System.out.println(localTime2.compareTo(localTime2));
		
		System.out.println(localTime.atDate(LocalDate.now()));
		
		System.out.println(localTime.plus(Duration.ofHours(1)));
		System.out.println(localTime.plus(2, ChronoUnit.HOURS));
		System.out.println(localTime.minus(2, ChronoUnit.MINUTES));
		
		System.out.println(localTime.withHour(1));
	}
}
