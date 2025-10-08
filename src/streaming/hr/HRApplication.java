package streaming.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HRApplication {
	
	public static void main(String[] args) {
		System.out.println("Departments and sum of sallaries");
		HRDataSource ds= new HRDataSource();
		
		//Total Salary by department
		
		Map<String, Double> departmentSalaries = 
				ds.getAllDepartments().stream()
				.flatMap(dept->dept.getEmployees().stream())
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));
		
		System.out.println(departmentSalaries);
		
		departmentSalaries = departmentSalaries.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1,e2)->e1,
						LinkedHashMap::new));
		System.out.println("Sorted Department salaries");
		System.out.println(departmentSalaries);
		
		departmentSalaries = departmentSalaries.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1,e2)->e1,
						LinkedHashMap::new));
		System.out.println("Reverse Sorted Department salaries");
		System.out.println(departmentSalaries);
		
		Map<String, Double> employeeSalaries = ds.getAllEmployees().stream()
		.sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary()))
		.collect(Collectors.toMap(
				Employee::getEmployeeId, 
				Employee::getSalary,
				(e1,e2)->e1,
				LinkedHashMap::new));
		
		System.out.println("Employee Salaries");
		System.out.println(employeeSalaries);
		
		//Total Salaries  using reducing
		System.out.println("Total Salaries using reducing");
		Double totalSalary = ds.getAllEmployees().stream()
				.collect(
						Collectors.reducing(0.0,
								Employee::getSalary,
								Double::sum
						)
				);
		
		System.out.println(totalSalary);
		
		//Total Salaries by Department using reducing
		System.out.println("Total Salaries by Department using reducing");
		Map<String, Double> totalSalaryByDepartment = ds.getAllEmployees().stream()
				.collect(Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.reducing(0.0,
								Employee::getSalary,
								Double::sum
								)
						));
		
		System.out.println(totalSalaryByDepartment);
		
		System.out.println("List of Employee names by Department");
		
		Map<String, List<String>> departmentEmpNames = ds.getAllEmployees().stream()
				.collect(Collectors.groupingBy(
							Employee::getDepartment,
							Collectors.mapping(Employee::getEmployeeName, Collectors.toList())
						));
		
		System.out.println(departmentEmpNames);
		

		
		System.out.println("List of Employee names by Department using iteration");
		
		Map<String, List<String>> departmentEmployeeNames = new HashMap<>();

		for(Employee emp: ds.getAllEmployees()) {
			departmentEmployeeNames.computeIfAbsent(emp.getDepartment(), k->new ArrayList<>())
			.add(emp.getEmployeeName());
		}
		
		System.out.println(departmentEmployeeNames);
		
		
		System.out.println("List of Employee names by Department using iteration");
        // Partition employees in three categories by salary level
        System.out.println("Partition employees in three categories by salary level");
        Map<String, List<Employee>> employeesBySalaryLevel = ds.getAllEmployees().stream()
            .collect(Collectors.groupingBy(emp -> {
                double salary = emp.getSalary();
                if (salary < 65000) return "LOW";
                else if (salary < 80000) return "MEDIUM";
                else return "HIGH";
            }));
        System.out.println(employeesBySalaryLevel);
        
        System.out.println("Partition employees in three categories by salary level using iteration");
        Map<String, List<Employee>> employeesBySalaryLevelIter = new HashMap<>();
        for (Employee emp : ds.getAllEmployees()) {
			String level;
			double salary = emp.getSalary();
			if (salary < 65000) level = "LOW";
			else if (salary < 80000) level = "MEDIUM";
			else level = "HIGH";

			employeesBySalaryLevelIter.computeIfAbsent(level, k -> new ArrayList<>()).add(emp);
		}
        System.out.println(employeesBySalaryLevelIter);
        
        System.out.println("Partition employees in two categories by salary level using partitioningBy");
        Map<Boolean, List<Employee>> employeesByHighSalary = ds.getAllEmployees().stream()
			.collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 80000));
        System.out.println(employeesByHighSalary);
		
		System.out.println("Partition employees in two categories by salary level and counting");
		Map<Boolean, Long> employeesByHighSalaryCounting = ds.getAllEmployees().stream()
			.collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 80000, Collectors.counting()));
		System.out.println(employeesByHighSalaryCounting);
		
		System.out.println("Parition employees in three categories by salary level and employee Ids and names");
		Map<String, List<String>> employeesBySalaryLevelNames = ds.getAllEmployees().stream()
			.collect(Collectors.groupingBy(emp -> {
				double salary = emp.getSalary();
				if (salary < 65000) return "LOW";
				else if (salary < 80000) return "MEDIUM";
				else return "HIGH";
			}, Collectors.mapping(emp -> "("+emp.getEmployeeId() + "," + emp.getEmployeeName()+")", Collectors.toList())));
		
		System.out.println(employeesBySalaryLevelNames);
		
		//iterate stream
		
		//fibonnaci series using iterate stream
		System.out.println("First 15 numbers in Fibonacci series");
		List<Integer> fibonnaci = 
				Stream.iterate(new int[] {0,1}, t-> new int[] {t[1], t[0]+t[1]})
				.limit(15)
				.map(t->t[0])
				.toList();
		
		System.out.println(fibonnaci);
		
		// fifteenth Fibonacci number
		System.out.println("Fifteenth Fibonacci number");
		int fifteenthFibonacci = 
				Stream.iterate(new int[] {0,1}, t-> new int[] {t[1], t[0]+t[1]})
				.limit(15)
				.map(t->t[0])
				.reduce((a,b)->b)
				.orElse(-1);
		System.out.println(fifteenthFibonacci);
		
		//teeing
		System.out.println("Average and total salary using teeing collector");
		Map<String, Double> avgAndTotalSalary = ds.getAllEmployees().stream()
			.collect(Collectors.teeing(
					Collectors.averagingDouble(Employee::getSalary),
					Collectors.summingDouble(Employee::getSalary),
					(avg, sum) -> {
						Map<String, Double> result = new LinkedHashMap<>();
						result.put("Average", avg);
						result.put("Total", sum);
						return result;
					}
			));
		
		System.out.println(avgAndTotalSalary);
		
		
		
	}

}