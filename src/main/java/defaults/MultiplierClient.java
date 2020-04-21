package defaults;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplierClient {
	public static void main(String[] args) {
		List<Integer> integerList = IntStream.range(1, 10).mapToObj(i->i).collect(Collectors.toList());
		Multiplier multiplier = new MultiplierImpl();
		System.out.println(multiplier.size(integerList));
		System.out.println(multiplier.muliply(integerList));
	
		System.out.println(Multiplier.isEmpty(integerList)); // static method called from Interface itself
	}
}
