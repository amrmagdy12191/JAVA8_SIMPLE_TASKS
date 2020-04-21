package streams;

import data.Bike;
import data.Student;
import data.StudentDataBase;

import static java.util.stream.Collectors.toList;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
	
	static Predicate<Student> gpaPredicate = s -> s.getGpa() >=3.9;
	static Predicate<Student> gradePredicate = s -> s.getGradeLevel() >=4;

	
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
	 
	 public static Map<String,List<Student>> groupingByGender(){
		 return StudentDataBase.getAllStudents().stream()
		 	.collect(Collectors.groupingBy(Student::getGender));
	 }
	 
	 public static void customizedGroupingBy(){
		 Map<String, List<Student>> studentsMap = StudentDataBase.getAllStudents()
				 					.stream()
				 					.collect(Collectors.groupingBy(s->s.getGpa() > 3.8 ?"OUTSTANDING" : "AVERAGE"));  
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void twoLevelGrouping(){
		 Map<String, Map<String,List<Student>>> studentsMap = StudentDataBase.getAllStudents()
				 .stream()
				 .collect(Collectors.groupingBy(Student::getGender,
						 Collectors.groupingBy(s->s.getGpa() > 3.8 ?"OUTSTANDING" : "AVERAGE")));
		 
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void twoLevelGrouping_2(){
		 Map<String, Integer> studentsMap = StudentDataBase.getAllStudents()
				 .stream()
				 .collect(Collectors.groupingBy(Student::getGender, 
						 Collectors.summingInt(Student::getNoteBooks)));
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void twoLevelGrouping_3(){
		 Map<String, Set<Student>> studentsMap = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.groupingBy(Student::getGender, Collectors.toSet()));
		 
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void threeLevelGrouping(){
		 LinkedHashMap<String, Set<Student>> studentsMap = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.groupingBy(Student::getGender,LinkedHashMap::new,Collectors.toSet()));
		 
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void calculteTopGpaStudentinEachGrade(){
		 Map<Integer, Optional<Student>> maxGPAforGradeMap = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		 
		 Stream.of(maxGPAforGradeMap).forEach(System.out::println);
		 
		Map<Integer, Student> studentsMap = StudentDataBase.getAllStudents().stream()
				 .collect(Collectors.groupingBy(Student::getGradeLevel,
						 						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student::getGpa)), // you can use minBy 
						 													Optional::get)));
		Stream.of(studentsMap).forEach(entity -> System.out.println(entity));
	 }
	 
	 public static void joining(){
		 String joiningResult = StudentDataBase.getAllStudents().stream()
		 .map(Student::getName)	
		 .collect(Collectors.joining());
		 System.out.println(joiningResult);		 
	 }
	 
	 public static void joiningWithDelimeter(){
		 String joiningResult = StudentDataBase.getAllStudents().stream()
		 .map(Student::getName)	
		 .collect(Collectors.joining("-"));
		 System.out.println(joiningResult);		 
	 }
	 
	 public static void joiningWithDelimeterPrefix(){
		 String joiningResult = StudentDataBase.getAllStudents().stream()
		 .map(Student::getName)	
		 .collect(Collectors.joining("-", "{", "}"));
		 System.out.println(joiningResult);		 
	 }
	 
	 public static  List<Student>  maxByMultipleStudents(){

         List<Student> maxStudents = new ArrayList<>();
         Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                 .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

         Student maxStudent = studentOptional.isPresent() ? studentOptional.get() : null ;
         System.out.println(maxStudent);
         if(maxStudent!=null){

             maxStudents = StudentDataBase.getAllStudents().stream()
                     .filter(student -> maxStudent.getGpa() == student.getGpa())
                     .collect(toList());

             System.out.println("Max Students are : " + maxStudents);
         }
         return maxStudents;
     }
	 
	 public static void collectorsMapping(){
		 Set<String> studentsNames = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		 System.out.println(studentsNames);
	 }
	 
	 public static Predicate<Student> gpaPredicate2 = s -> s.getGpa() > 3.8;
	 
	 public static void partitioningBy_1(){
		 Map<Boolean, List<Student>> studentsMap = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.partitioningBy(gpaPredicate2));
		 
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void partitioningBy_2(){
		 Map<Boolean, Set<Student>> studentsMap = StudentDataBase.getAllStudents().stream()
				 .collect(Collectors.partitioningBy(gpaPredicate2, Collectors.toSet()));
				 
				 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static void partitioningBy_3(){
		 Map<Boolean, Map<String, List<String>>> studentsMap = StudentDataBase.getAllStudents().stream()
		 .collect(Collectors.partitioningBy(gpaPredicate2, Collectors.toMap(Student::getName, Student::getActivities)));
		 
		 Stream.of(studentsMap).forEach(System.out::println);
	 }
	 
	 public static Optional<String> getStudentNameOptional(){
		 Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.getOptionalStudent().get());
		
		 if(optionalStudent.isPresent())
			return  optionalStudent.map(Student::getName);
		 
		 return Optional.empty();
	 }
	 
	 public static void optionalFlatMap(){
		 Optional<Bike> optionalBike =  StudentDataBase.getOptionalStudent()
				 .flatMap(Student::getBike);
		 
		 if(optionalBike.isPresent())
			 System.out.println(optionalBike.get());
	 }
	 
	 public static void optionalFilter(){
		 Optional<Student> student = StudentDataBase.getOptionalStudent().filter(s -> s.getGpa() >4.3);
		 if(student.isPresent())
			 System.out.println(student.get());
		 else
			 System.out.println("Not Qualified Student");
	 }
	 
	 public static void optionalOrElse(){
		 String studentName = StudentDataBase.getOptionalStudent().map(Student::getName).orElse("Default");
		 System.out.println(studentName);
		 
		 Optional<Student> optionalStudent = Optional.ofNullable(null);
		 String studentName2 = optionalStudent.map(Student::getName).orElse("Default");
		 System.out.println(studentName2);
		
	 }
	 
	 public static void optionalOrElseGet(){
		 Optional<Student> optionalStudent = Optional.ofNullable(null);
		 Student student = optionalStudent.map(s->s).orElseGet(() -> StudentDataBase.getOptionalStudent().get());
		 System.out.println(student);
		 
		 String name =  optionalStudent.map(Student::getName).orElseGet(()->"Default");
		 System.out.println(name);
	 }
	 
	 public static void optionalOrElseThrow(){
		 Optional<Student> optionalStudent = Optional.ofNullable(null);
		 
		 String name = optionalStudent.map(Student::getName).orElseThrow(() -> new RuntimeException("No Student Found!"));
		 System.out.println(name);
	 }
	 
		public static void main(String[] args) {
//			List<String> names = Arrays.asList("adam","dan","jenny");
//			
//			names.stream().forEach(s -> {
//				 System.out.println(LocalTime.now() + " :: " + s +
//						 " :: " + Thread.currentThread().getName());});
//			
//			// not recommended foRr container like j2ee severs
//			names.parallelStream().forEach(s -> {
//				 System.out.println(LocalTime.now() + " :: " + s +
//						 " :: " + Thread.currentThread().getName());});
			
//			List<String> StudentsNamesList = StudentDataBase.getAllStudents().stream()
//				.filter(gpaPredicate)
//				.peek(System.out::println) // s -> System.out.println(s)
//				.filter(gradePredicate)
//				.peek(System.out::println)
//				.map(Student::getName)		
//				.collect(Collectors.toList());
//			System.out.println(StudentsNamesList);
//			
//			List<Double> StudentsGpaList = StudentDataBase.getAllStudents().stream()
//					.filter(gpaPredicate)
//					.peek(System.out::println) // s -> System.out.println(s)
//					.map(Student::getGpa)
//					.distinct()
//					.collect(Collectors.toList());
//			System.out.println(StudentsGpaList);
//			
//			
//			List<String> StudentsActivitiesList = StudentDataBase.getAllStudents().stream()
//					.map(Student::getActivities)
//					.flatMap(List::stream)
//					.distinct()
//					.sorted()
//					.collect(Collectors.toList());
//			System.out.println(StudentsActivitiesList);
//			
//			long StudentsCount = StudentDataBase.getAllStudents().stream()
//					.map(Student::getActivities)
//					.flatMap(List::stream)
//					.distinct()
//					.count();
//			System.out.println(StudentsCount);
//			
//			List<Student> StudentsGpaComparatorList = StudentDataBase.getAllStudents().stream()
//					.sorted(Comparator.comparing(Student::getGpa).reversed())
//					.collect(Collectors.toList());
//			System.out.println(StudentsGpaComparatorList);
			
			List<Integer> integerList = Arrays.asList(1,3,5,7);
//			
//			System.out.println(integerList.stream().reduce(1, (a,b)->a*b));		
//			Optional<Integer> result = integerList.stream().reduce((a,b) -> a*b);
//			if(result.isPresent())
//				System.out.println(result.get());
//			
//			List<Integer> emptyList = new ArrayList<>();
//			Optional<Integer> resultEmpty = emptyList.stream().reduce((a,b) -> a*b);
//			if(resultEmpty.isPresent())
//				System.out.println(resultEmpty.get());
//			
//			Optional<Student> student = getHighestGradeStudent(StudentDataBase.getAllStudents());
//			if(student.isPresent())
//				System.out.println(student.get());
//			else
//				System.out.println("Invalid Input Empty List");
//			
//			System.out.println(combineStudentsNames(StudentDataBase.getAllStudents()));
			
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
			
			System.out.println(groupingByGender());
			System.out.println();
			customizedGroupingBy();
			twoLevelGrouping();
			twoLevelGrouping_2();
			twoLevelGrouping_3();
			threeLevelGrouping();
			calculteTopGpaStudentinEachGrade();
			
			calculteTopGpaStudentinEachGrade();
			joining();
			joiningWithDelimeter();
			joiningWithDelimeterPrefix();
			maxByMultipleStudents();
			collectorsMapping();
			partitioningBy_1();
			partitioningBy_2();
			partitioningBy_3();
			
			Optional<String> studentNameOptional = getStudentNameOptional();
			if(studentNameOptional.isPresent())
				System.out.println(studentNameOptional.get());
			else
				System.out.println("Object is empty!");
			
			
			optionalFlatMap();
			optionalFilter();
			optionalOrElse();
			optionalOrElseGet();
			optionalOrElseThrow();
		}
	
}
