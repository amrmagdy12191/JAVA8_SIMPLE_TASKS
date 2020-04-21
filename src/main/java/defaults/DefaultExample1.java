package defaults;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDataBase;

public class DefaultExample1 {
	
	static Comparator<Student> nameComparator= Comparator.comparing(Student::getName);
	static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
	static Comparator<Student> genderComparator = Comparator.comparing(Student::getGender);
	static Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGradeLevel);
	static Consumer<Student> studentConsumer = s->System.out.println(s);
	
	static List<Student> studentsList = StudentDataBase.getAllStudents();
	static List<Student> nullableStudentsList = StudentDataBase.getAllStudentsPlusNull();
	public static void sortByName(){
		studentsList.sort(nameComparator);
		studentsList.forEach(studentConsumer);
		
		nullableStudentsList.sort(Comparator.nullsFirst(nameComparator));
		nullableStudentsList.forEach(studentConsumer);
	}
	
	public static void comparatorChaining() {
		System.out.println("comparatorChaining :");
		studentsList.sort(gradeComparator.thenComparing(gpaComparator));
		studentsList.forEach(studentConsumer);
	}

	public static void main(String[] args) {
		List<String> stringList  = Arrays.asList("Adam", "Jenny", "Alex","Eric","Mike");
		
		stringList.sort(Comparator.naturalOrder());
		System.out.println(stringList);
		
		stringList.sort(Comparator.reverseOrder());
		System.out.println(stringList);
		
		sortByName();
		comparatorChaining();
	}
}
