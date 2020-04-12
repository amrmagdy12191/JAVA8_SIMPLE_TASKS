package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import data.Student;
import data.StudentDataBase;

public class SupplierExample {
	
	// supplier has one function -> no input and return output
	
	static Supplier<Student> studentSupplier = () ->{
		return new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"));
	};
	
	static Supplier<List<Student>> allStudentsSupplier = () -> StudentDataBase.getAllStudents();
	
	public static void main(String[] args) {
		System.out.println(studentSupplier.get());
		System.out.println(allStudentsSupplier.get());
	}
}
