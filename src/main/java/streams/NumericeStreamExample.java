package streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericeStreamExample {
	
	public static int sumOfNumbersIntStream(){
		return IntStream.range(1, 6).sum();
	}
	
	 public static List<Integer> mapToObj(){
		 return IntStream.range(1, 50).mapToObj(i -> {
			 return new Integer(i);
		 }).collect(Collectors.toList());
	 }
	 
	 public static double mapToDouble(){
		 return IntStream.range(1, 50).mapToDouble(i -> {
			 return i;
		 }).sum();
	 }
	 
	 public static long mapToLong(){
		 return IntStream.range(1, 50).mapToLong(i -> i).sum();
	 }
	 
	 public static void mapAsDoubleStream(){
		 IntStream.rangeClosed(1, 50).asDoubleStream().forEach(s -> System.out.print(s + ","));
	 }
	 
	 public static long mapAsLongStream(){
		 return IntStream.rangeClosed(1, 50).asLongStream().sum();
	 }
	 
	 public static List<Integer> boxing() {
		 return IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());
	 }
	 
	 public static int unboxing(List<Integer> integerList) {
		 return integerList.stream().mapToInt(Integer::intValue).sum();
	 }

	public static void main(String[] args) {
		System.out.println(sumOfNumbersIntStream());
		
		System.out.println(IntStream.rangeClosed(1, 50).count());
		System.out.println(IntStream.range(1, 50).count());
		
		IntStream.range(1, 50).forEach(s -> System.out.print(s + ","));
		System.out.println();
		IntStream.rangeClosed(1, 50).forEach(s -> System.out.print(s + ","));
		System.out.println();
		
		System.out.println(mapToObj());
		System.out.println(mapToDouble());
		System.out.println(mapToLong());
		
		mapAsDoubleStream();
		
		System.out.println();
		System.out.println(mapAsLongStream());
		
		System.out.println(boxing());
		System.out.println(unboxing(boxing()));
		
		
		OptionalInt max = IntStream.rangeClosed(1,50).max();
		if(max.isPresent())
			System.out.println(max.getAsInt());
		
		OptionalInt min = IntStream.rangeClosed(1,50).min();
		System.out.println(min.getAsInt());
		
		OptionalDouble average = IntStream.rangeClosed(1,50).average();
		System.out.println(average.getAsDouble());
		
	}
}
