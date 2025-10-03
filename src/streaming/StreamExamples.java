package streaming;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
	public static void main(String[] args) {
		List<Student> students = StudentData.getStudents();
		
		System.out.println("List of Student names:");
		students.stream().map(Student::getName).forEach(System.out::println);
		
		System.out.println("\n Student names and their total number of courses:");
		students.stream().forEach(s->System.out.println(s.getName()+" : "+s.getCourses().size()));
		System.out.println("\n Student names and their total number of credits:");
		
		students.stream()
		.forEach(s -> {
		    int totalCredits = s.getCourses().stream()
		        .mapToInt(c -> c.getCredits())
		        .sum();
		    System.out.println(s.getName() + ": " + totalCredits);
		});
		
		System.out.println("\n Student names and their department names:");
		students.stream().forEach(s->System.out.println(s.getName()+" : "+s.getDepartment().getDeptName()));
		
		System.out.println("\n Student names who have 10 or more credits:");
		
		students.stream().forEach(s -> {
		    int totalCredits = s.getCourses().stream()
		        .mapToInt(c -> c.getCredits())
		        .sum();
		    if (totalCredits >= 10) {
		        System.out.println(s.getName() + ": " + totalCredits);
		    }
		});
		
		System.out.println("\n Student total credits:");
		int sC = students.stream()
		.map(s -> s.getCourses().stream().mapToInt(c -> c.getCredits()).sum())
		.collect(Collectors.summingInt(Integer::intValue));
		
		System.out.println("Summing credits: "+sC);
		
		//using reduce example to get total credits
		int sCr = students.stream().map(s -> s.getCourses().stream().mapToInt(c -> c.getCredits()).sum())
				.reduce(0, (a,b)->a+b);
		
		System.out.println("Summing credits using reduce: "+sCr);
		
		
		// flatmap to get student names and their course names
		
		System.out.println("\n Student names and their course names:");
		
		students.stream()
		.flatMap(s -> s.getCourses().stream().map(c -> s.getName() + " -> " + c.getCourseName()))
		.forEach(System.out::println);
		
	}
}