package dates;

import java.time.LocalDate;
import java.time.Period;

public class ComparingLocalDates {
	public static void main(String[] args) {
		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = LocalDate.of(2018, 01, 12);
		
		System.out.println(localDate1.until(localDate2));
		System.out.println(localDate2.until(localDate1));
		
		Period period = localDate2.until(localDate1);
		
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		
		Period period2 = Period.ofYears(20);
		System.out.println(period2.getYears());
		System.out.println(period2.getMonths());
		System.out.println(period2.getDays());
		System.out.println(period2.toTotalMonths());
		
		Period period3 = Period.between(localDate2, localDate1);
		System.out.println(period3.getYears());
		System.out.println(period.getMonths());
		System.out.println(period3.getDays());
		
	}
}
