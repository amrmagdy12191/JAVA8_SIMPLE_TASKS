package defaults;


public class Client14 implements Interface1, Interface4 {
	
	   public void  methodA(){
	        System.out.println("Inside method A "+Client14.class);
	    }
	
	public static void main(String[] args) {
		new Client14().methodA(); // print child interface method if method is not implemented inside client
	}
}
