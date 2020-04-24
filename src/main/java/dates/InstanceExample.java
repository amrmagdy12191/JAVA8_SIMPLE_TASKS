package dates;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstanceExample {
	public static void main(String[] args) {
		Instant instant = Instant.now(); // Represents the date and time in unix timestamp in a machine readable format.
		System.out.println(instant);
		
		System.out.println(instant.getEpochSecond());
		
		Instant instant2 = Instant.ofEpochMilli(1207664750);
		System.out.println(instant2);
		
		System.out.println(instant.compareTo(instant2));
		
		System.out.println(instant.get(ChronoField.MILLI_OF_SECOND));
	}
}
