package streams;

import java.util.stream.IntStream;

public class NumericeStreamExample {
	
	public static int sumOfNumbersIntStream(){
		return IntStream.range(1, 6).sum();
	}

	public static void main(String[] args) {
		System.out.println(sumOfNumbersIntStream());
	}
}
