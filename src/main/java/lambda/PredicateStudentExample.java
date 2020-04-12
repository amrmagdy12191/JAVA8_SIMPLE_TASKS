package lambda;

import java.util.function.Predicate;

import data.Student;

public class PredicateStudentExample {
	
	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >=3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

}
