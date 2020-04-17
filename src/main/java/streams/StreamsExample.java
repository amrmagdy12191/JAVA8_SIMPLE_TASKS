package streams;

import data.Student;
import data.StudentDataBase;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
	
	static Predicate<Student> gpaPredicate = s -> s.getGpa() >=3.9;
	static Predicate<Student> gradePredicate = s -> s.getGradeLevel() >=4;

	public static void main(String[] args) {
//		List<String> names = Arrays.asList("adam","dan","jenny");
//		
//		names.stream().forEach(s -> {
//			 System.out.println(LocalTime.now() + " :: " + s +
//					 " :: " + Thread.currentThread().getName());});
//		
//		// not recommended foRr container like j2ee severs
//		names.parallelStream().forEach(s -> {
//			 System.out.println(LocalTime.now() + " :: " + s +
//					 " :: " + Thread.currentThread().getName());});
		
//		List<String> StudentsNamesList = StudentDataBase.getAllStudents().stream()
//			.filter(gpaPredicate)
//			.peek(System.out::println) // s -> System.out.println(s)
//			.filter(gradePredicate)
//			.peek(System.out::println)
//			.map(Student::getName)		
//			.collect(Collectors.toList());
//		System.out.println(StudentsNamesList);
//		
//		List<Double> StudentsGpaList = StudentDataBase.getAllStudents().stream()
//				.filter(gpaPredicate)
//				.peek(System.out::println) // s -> System.out.println(s)
//				.map(Student::getGpa)
//				.distinct()
//				.collect(Collectors.toList());
//		System.out.println(StudentsGpaList);
//		
//		
//		List<String> StudentsActivitiesList = StudentDataBase.getAllStudents().stream()
//				.map(Student::getActivities)
//				.flatMap(List::stream)
//				.distinct()
//				.sorted()
//				.collect(Collectors.toList());
//		System.out.println(StudentsActivitiesList);
//		
//		long StudentsCount = StudentDataBase.getAllStudents().stream()
//				.map(Student::getActivities)
//				.flatMap(List::stream)
//				.distinct()
//				.count();
//		System.out.println(StudentsCount);
//		
//		List<Student> StudentsGpaComparatorList = StudentDataBase.getAllStudents().stream()
//				.sorted(Comparator.comparing(Student::getGpa).reversed())
//				.collect(Collectors.toList());
//		System.out.println(StudentsGpaComparatorList);
		
		List<Integer> integerList = Arrays.asList(1,3,5,7);
//		
//		System.out.println(integerList.stream().reduce(1, (a,b)->a*b));		
//		Optional<Integer> result = integerList.stream().reduce((a,b) -> a*b);
//		if(result.isPresent())
//			System.out.println(result.get());
//		
//		List<Integer> emptyList = new ArrayList<>();
//		Optional<Integer> resultEmpty = emptyList.stream().reduce((a,b) -> a*b);
//		if(resultEmpty.isPresent())
//			System.out.println(resultEmpty.get());
//		
//		Optional<Student> student = getHighestGradeStudent(StudentDataBase.getAllStudents());
//		if(student.isPresent())
//			System.out.println(student.get());
//		else
//			System.out.println("Invalid Input Empty List");
//		
//		System.out.println(combineStudentsNames(StudentDataBase.getAllStudents()));
		
		List<Student> studentsList = StudentDataBase.getAllStudents();
		
		System.out.println(maxValue(integerList).get());
		System.out.println(maxValueStudentGrade(studentsList).get());
		
		System.out.println(limit(integerList).get());
		System.out.println(skip(integerList).get());
		
		System.out.println(allMatch(studentsList));
		System.out.println(noneMatch(studentsList));
		System.out.println(anyMatch(studentsList));
		
		System.out.println(findAny(studentsList).get());
		System.out.println(findFirst(studentsList).get());
		
		Stream.iterate(1, x->x*2)
			.limit(10)
			.forEach(i -> System.out.println(i));
		Stream.iterate("a",  x-> x.concat("b"))
			.limit(5)
			.forEach( i-> System.out.println(i));
		
		List<Integer> intList = Stream.iterate(1,  x->x*2)
			.limit(10)
			.collect(Collectors.toList());
		System.out.println(intList);
		
		Stream.generate(Student::new).limit(5).forEach(s -> System.out.println(s));
		
		Supplier<Integer> randomInt =  new Random()::nextInt;
		List<Integer> intList2 = Stream.generate(randomInt).limit(5).collect(Collectors.toList());
		System.out.println(intList2);
		
	}
	
	public static Optional<Student> getHighestGradeStudent(List<Student> studensList){
		return studensList.stream()
			.reduce((s1,s2)-> {
				if(s1.getGradeLevel() > s2.getGradeLevel())
					return s1;
				else
					return s2;
			});
	}
	
	public static String combineStudentsNames(List<Student> studensList){
		return studensList.stream()
				.map(Student::getName)
				.reduce("", (n1,n2)-> n1.concat(n2));
	}
	
	 public static Optional<Student> maxValueStudentGrade(List<Student>  studentList){
		 return studentList.stream()
				 .reduce((s1,s2) -> s1.getGpa() > s2.getGpa() ? s1:s2);
	 }
	 
	 public static Optional<Integer> maxValue(List<Integer> integerList){
	        return integerList.stream()
	        	//	.reduce((a, b) -> a>b? a:b);
	        		.reduce(Integer::max);
	 }
	 
	 public static Optional<Integer> limit(List<Integer> integers){
		 return integers.stream()
		 	.limit(3)
		 	.reduce((a,b)->a*b);
	 }
	 
	 public static Optional<Integer> skip(List<Integer> integers){
		 return integers.stream()
				 .skip(2)
				 .reduce((a,b) -> a+b);
	 }
	 
	 public static boolean allMatch(List<Student> studensList){
		 return studensList.stream()
				 .allMatch(s-> s.getGpa() > 4);
	 }
	 
	 public static boolean anyMatch(List<Student> studensList){
		 return studensList.stream()
		 .anyMatch(s -> s.getGradeLevel() == 4);
	 }
	
	 public static boolean noneMatch(List<Student> studensList){
		 return studensList.stream()
				 .noneMatch(s-> s.getGpa() > 4);
	 }
	 
	 public static Optional<Student> findAny(List<Student> studensList){
		 return studensList.stream()
				 .filter(s -> s.getGpa() >=3.9)
				 .findAny();
	 }
	 
	 public static Optional<Student> findFirst(List<Student> studensList){
		 return studensList.stream()
				 .filter(s -> s.getGpa() >=3.9)
				 .findFirst();
	 }
	
}
