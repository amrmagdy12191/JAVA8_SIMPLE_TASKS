package lambda;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import model.Student;
import model.StudentDataBase;

public class BiConsumerExample {

	public static void nameAndActivities(){
		
		
		BiConsumer<String, List<String>> namesActiveConsumer = (a,b) -> System.out.println(a + " : " + b);
		
		Consumer<Student> foreachConsumer = (s) -> namesActiveConsumer.accept(s.getName(), s.getActivities());
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(foreachConsumer);
		System.out.println("----");
		students.forEach((s)->namesActiveConsumer.accept(s.getName(), s.getActivities()));
	}
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> multiplyConsumer = (a,b) -> System.out.println(a*b);		
		BiConsumer<Integer, Integer> addConsumer = (a,b) -> System.out.println(a+b);
		
		multiplyConsumer.andThen(addConsumer).accept(4, 5);
		nameAndActivities();
	
		
	}
}
