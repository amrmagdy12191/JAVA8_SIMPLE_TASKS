package lambda;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> toUpperCase = (str) -> str.toUpperCase();
	static Function<String, String> addSomeString = (str) -> str.concat("default");
	static Function<String, Integer> stringLength = (str) -> str.length();
	
	public static void main(String[] args) {
		System.out.println("Result is : " + toUpperCase.apply("java8"));
		
		System.out.println(toUpperCase.andThen(addSomeString).apply("java8"));
		
		System.out.println(toUpperCase.compose(addSomeString).apply("java8"));
		
		Function<String, String> func = Function.identity();
		System.out.println(func.apply("AABC"));
	}
}
