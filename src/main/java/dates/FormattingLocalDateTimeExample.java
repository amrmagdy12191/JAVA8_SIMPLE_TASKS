package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {
	
	public static void parseLocalDate(){
		String date = "2018-04-18";
		 LocalDate localDate = LocalDate.parse(date);
		 System.out.println(localDate);
		 
		 LocalDate localDate2 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		 System.out.println(localDate2);
		 
		 String isoDate = "20180418";
		 LocalDate localDate3 = LocalDate.parse(isoDate, DateTimeFormatter.BASIC_ISO_DATE);
		 System.out.println(localDate3);
		 
		 String customDate = "2018|04|18";
		 LocalDate localDate4 = LocalDate.parse(customDate, DateTimeFormatter.ofPattern("yyyy|MM|dd"));
		 System.out.println(localDate4);
		 
		 
	}
	
	public static void formatLocalDate(){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.format(dateTimeFormatter));
	}
	
	public static void parseLocalTime(){
		 String time = "23*40";
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH*mm");
		 System.out.println(LocalTime.parse(time, dateTimeFormatter));
		 
		 System.out.println(LocalTime.parse("23:55", DateTimeFormatter.ISO_TIME));
	}
	
	public static void formatLocalTime(){
		 LocalTime localTime = LocalTime.now();
		 String time =localTime.format(DateTimeFormatter.ofPattern("HH^/mm^/ss"));
		 System.out.println(time);
	}
	
	public static void parseLocalDateTime(){
		String dateTime = "2018-04-18T14:33:33";
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(localDateTime);
		
		String dateTime1 = "2018-04-1814|33|33";
		LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime1, DateTimeFormatter.ofPattern("yyyy-MM-ddHH|mm|ss"));
		System.out.println(localDateTime2);
	}
	
	public static void formatLocalDateTime(){
		LocalDateTime localDateTime = LocalDateTime.now();
		String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss"));
		String dateTime2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss"));
		System.out.println(dateTime);
		System.out.println(dateTime2);
		 
	}
	
	public static void main(String[] args) {
		parseLocalDate();
		formatLocalDate();
		parseLocalTime();
		formatLocalTime();
		parseLocalDateTime();
		formatLocalDateTime();
		
	}

}
