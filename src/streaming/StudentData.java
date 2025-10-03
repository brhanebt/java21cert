package streaming;

import java.time.LocalDate;
import java.util.List;

public class StudentData {
	
	public static List<Student> getStudents() {
		return List.of(
			new Student("S001", "Alice Johnson", LocalDate.of(2000, 5, 15),
				List.of(
					new Course("C101", "Introduction to Programming", 3),
					new Course("C102", "Data Structures", 4),
					new Course("C103", "Database Systems", 3)
				),
				new Department("D01", "Computer Science", "Building A"), 3.8
			),
			new Student("S002", "Bob Smith", LocalDate.of(1999, 8, 22),
				List.of(
					new Course("C103", "Database Systems", 3),
					new Course("C104", "Operating Systems", 4),
					new Course("C105", "Computer Networks", 3)
				),
				new Department("D01", "Computer Science", "Building A"), 3.5
			),
			new Student("S003", "Charlie Brown", LocalDate.of(2001, 2, 10),
				List.of(
					new Course("C201", "Calculus I", 4),
					new Course("C202", "Linear Algebra", 3)
				),
				new Department("D02", "Mathematics", "Building B"), 3.9
			),
			new Student("S004", "Diana Prince", LocalDate.of(2000, 11, 30),
				List.of(
					new Course("C301", "Introduction to Psychology", 3),
					new Course("C302", "Cognitive Science", 4)
				),
				new Department("D03", "Psychology", "Building C"), 3.7
			),
			new Student("S005", "Ethan Hunt", LocalDate.of(1998, 7, 4),
				List.of(
					new Course("C401", "World History", 3),
					new Course("C402", "Political Science", 4)
				),
				new Department("D04", "History", "Building D"),	 3.6
				),
			new Student("S006", "Fiona Gallagher", LocalDate.of(2001, 3, 18),
					List.of(
					new Course("C501", "Microeconomics", 3),
					new Course("C502", "Macroeconomics", 4)
				),
				new Department("D05", "Economics", "Building E"), 3.85
				)
			);
	}

}
