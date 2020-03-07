package lambda;

public class Main {
	
	public static void main(String[] args) {
		//Old java 7
		Runnable runnable = new Runnable() {
			
			public void run() {
				System.out.println("Inside Runnable");
			}
		};
		
		new Thread(runnable).start();
		
		// Java 8
		
		Runnable runnable2 = () ->{
			System.out.println("Inside Runnable 2");
			System.out.println("Inside Runnable 3");
		};
		new Thread(runnable2).start();
		
		new Thread(()->{
			System.out.println("Inside Runnable 4");
			System.out.println("Inside Runnable 5");
		}).start();
		
		new Thread(()->System.out.println("Inside Runnable 6")).start();
	}
	

}
