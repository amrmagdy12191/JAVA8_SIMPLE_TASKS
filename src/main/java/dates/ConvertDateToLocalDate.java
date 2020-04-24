package dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDateToLocalDate {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(localDate);
		
		LocalDate localDate3 = LocalDate.now();
		Date date3 = new Date().from(localDate3.atTime(LocalTime.now()).atZone(ZoneId.of("America/Chicago")).toInstant());
		System.out.println(date3);
		
		
		/**
         *  LocalDate to java.sql.Date
         */
		java.sql.Date date2 = java.sql.Date.valueOf(localDate);
		System.out.println(date2);
		
		LocalDate localDate2 = date2.toLocalDate();
		System.out.println(localDate2);
	}
}
