package lambda;

import java.util.Comparator;

/**
 * @author amrmagdy
 *
 */
public class ComparatorExample {
	static Comparator<Integer> comparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	static Comparator<Integer> c2 = (o1,o2)->o1.compareTo(o2); 
	
	public static void main(String[] args) {
		System.out.println(comparator.compare(5, 6));
		System.out.println(c2.compare(5,6));
		System.out.println();
	}
	
	//Comparator<Integer> c1
}
