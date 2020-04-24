package dates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimeDuration {
	public static void main(String[] args) {
		LocalTime localTime1= LocalTime.of(1, 3, 55);
		LocalTime localTime2= LocalTime.of(22, 50, 56);
		
		System.out.println(localTime1.until(localTime2, ChronoUnit.HOURS));
		
		Duration duration = Duration.between(localTime1, localTime2);
		System.out.println(duration.toDays());
		System.out.println(duration.toHours());
		System.out.println(duration.toMinutes());
		
		Duration duration2 = Duration.ofHours(10);
		System.out.println(duration2.toMinutes());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime localDateTime2 = LocalDateTime.now().plusDays(5);
		Duration duration3 = Duration.between(localDateTime, localDateTime2);
		//System.out.println(duration3.get(ChronoUnit.DAYS)); unsupported
		
		System.out.println(duration3.toDays());
	//	System.out.println(duration3.get(ChronoUnit.HOURS)); unsupported
		System.out.println(duration3.toHours());
		
		
	}
}
