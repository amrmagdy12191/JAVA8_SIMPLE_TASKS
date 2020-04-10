package lambda;

import java.util.function.Predicate;

public class PredicateExample {
	
	static Predicate<Integer> p1 = (i) -> i%2==0;
	static Predicate<Integer> p2 = (i) -> i%5==0;
	
	 public static void predicateAnd(){
		 System.out.println(p1.and(p2).test(4));
	 }
	 
	public static void predicateOR(){
		System.out.println(p1.or(p2).test(5));
	}
	
	public static void predicateNegate(){
		 System.out.println(p1.and(p2).negate().test(10));
	}

	public static void main(String[] args) {
		predicateAnd();
		predicateOR();
		predicateNegate();

	}

}
