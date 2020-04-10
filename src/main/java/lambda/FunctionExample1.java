package lambda;

public class FunctionExample1 {

	
	public static String applyDefault(String input){
		return FunctionExample.addSomeString.apply(input);
	}
	public static void main(String[] args) {
		System.out.println(applyDefault("test"));
	}
}
