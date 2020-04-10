package methodRefrence;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import model.Student;
import model.StudentDataBase;
/**
 * Simplify Function Lambda expression
 * @author Amr Magdy
 *
 */
public class MethodRefrenceExample {
	static Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();
	
	static Function<String,String> toUpperMethodRefrence = String::toUpperCase;
	
	
	
	static Consumer<Student>  c1= p -> System.out.println(p);

	static Consumer<Student>  c1MethodRefrence= System.out::println;
	
	static Consumer<Student>  c2MethodRefrence= Student::printListOfActivities;
	
	
	
	static Predicate<Student> predicateUsingMetRef = MethodRefrenceExample::greaterThan;

    static BiPredicate<Student,Integer> predicateUsingMethodReference = MethodRefrenceExample::greaterThan;
 
    
    
    static Supplier<Student> supplier = Student::new;
    static Function<String, Student> function = Student::new;
    
    
    static public  boolean greaterThan(Student student){

        return student.getGradeLevel() >3;
    }

   static public  boolean greaterThan(Student student,Integer grade){

        return student.getGradeLevel() >grade;
    }
	
	public static void main(String[] args) {
		System.out.println(toUpperCaseLambda.apply("java8"));
		System.out.println(toUpperMethodRefrence.apply("java8"));
		
		System.out.println("------");
		StudentDataBase.getAllStudents().forEach(c1MethodRefrence);
		
		System.out.println("------");
		StudentDataBase.getAllStudents().forEach(c2MethodRefrence);
		
		System.out.println("------");
        System.out.println(predicateUsingMetRef.test(StudentDataBase.studentSupplier.get()));
        System.out.println(predicateUsingMethodReference.test(StudentDataBase.studentSupplier.get(),3));
        
        System.out.println("------");
        System.out.println(supplier.get());
        System.out.println(function.apply("ABC"));
	}
}
