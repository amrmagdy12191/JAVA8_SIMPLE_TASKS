package defaults;

import java.util.List;

public class MultiplierImpl implements Multiplier {

	@Override
	public int muliply(List<Integer> integerList) {
		return integerList.stream().reduce(1, (a,b) -> a*b);
	}
	
	@Override
	public int size(List<Integer> integerList) {
		System.out.println("Inside Implementation");
		return integerList.size();
	}

}
