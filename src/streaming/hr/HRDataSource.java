package streaming.hr;

import java.util.Arrays;
import java.util.List;

public class HRDataSource {
	
	public List<Employee> getAllEmployees() {
		
		return getAllDepartments().stream()
				.flatMap(dept->dept.getEmployees().stream())
				.toList();
	}
	
	public List<Department> getAllDepartments() {
		return Arrays.asList(
				new Department("D001", "HR", "E001", Arrays.asList(
						new Employee("E001", "Alice","HR", "HR Manager", 90000.0, null),
						new Employee("E002", "Bob", "HR", "HR Specialist", 60000.0, "E001"),
						new Employee("E006", "Frank", "HR", "Recruiter", 55000.0, "E002")
						)),
				new Department("D002", "IT", "E003", Arrays.asList(
						new Employee("E003", "Charlie", "IT", "IT Manager", 95000.0, null),
						new Employee("E004", "David", "IT", "Software Engineer", 80000.0, "E003"),
						new Employee("E005", "Eva", "IT", "System Administrator", 75000.0, "E003")
						)),
				new Department("D003", "Finance", "E007", Arrays.asList(
						new Employee("E007", "Grace", "Finance", "Finance Manager", 92000.0, null),
						new Employee("E008", "Hank", "Finance", "Accountant", 65000.0, "E007")
						))
				
				);
	}

}
