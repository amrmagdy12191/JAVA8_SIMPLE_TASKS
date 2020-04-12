package lambda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import data.Student;
import data.StudentDataBase;

public class BiPredicateExample {
	static BiPredicate<Integer, Double> bip = (gradeLevel, gpa) -> gradeLevel>=3 && gpa>=3.9;
	
	static Consumer<Student> c = (student) ->{
		if(bip.test(student.getGradeLevel(), student.getGpa()))
			System.out.println(student.getName());
	};
	
	public static void main(String[] args) {
		List<Student> studentsList = StudentDataBase.getAllStudents();
		studentsList.forEach(c);
	}
}
