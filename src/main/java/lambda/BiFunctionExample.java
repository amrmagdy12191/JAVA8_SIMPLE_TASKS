package lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import data.Student;
import data.StudentDataBase;

public class BiFunctionExample {
	
	static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction = (studentList, predicate) ->{
		Map<String, Double> studentGpaMap = new HashMap();
		
		studentList.forEach((s) ->{
			if(predicate.test(s))
				studentGpaMap.put(s.getName(), s.getGpa());
		});
		
		return studentGpaMap;
	};

	public static void main(String[] args) {
		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p2));
	}
}
