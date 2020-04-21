package defaults;

public class Client123 implements Interface1, Interface2, Interface3 {

	
	public static void main(String[] args) {
		new Client123().methodA(); // print child interface method if method is not implemented inside client
	}
}
