package dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.swing.plaf.synth.SynthSliderUI;

public class LocalDateExample {
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalDate localDate2 = LocalDate.of(2020, 01, 12);
		System.out.println(localDate2);
		
		System.out.println(localDate.getEra());
		System.out.println(localDate.getDayOfYear());
		System.out.println(localDate.getMonthValue());
		
		System.out.println(localDate.plusWeeks(1));
		System.out.println(localDate.plusDays(1));
		System.out.println(localDate.with(ChronoField.YEAR, 2025));
		
		System.out.println(localDate.minus(2,ChronoUnit.YEARS));
		
		System.out.println(localDate.isSupported(ChronoUnit.MINUTES));
		
		System.out.println(localDate.isLeapYear());
		
		System.out.println(localDate.isBefore(localDate2));
		System.out.println(localDate.isAfter(localDate2));
		System.out.println(localDate.isEqual(localDate2));
	}

}
