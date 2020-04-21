package defaults;

import java.util.List;

public interface Multiplier {
	
	int muliply(List<Integer> integerList);
	
	static boolean isEmpty(List<Integer> integerList){
		return integerList != null && integerList.size() == 0; 
	}
	
	default int size(List<Integer> integerList){
		System.out.println("Inside interface");
		return integerList.size();
	}

}
