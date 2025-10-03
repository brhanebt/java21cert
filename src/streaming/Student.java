package streaming;

import java.time.LocalDate;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private LocalDate dob;
	private List<Course> courses;
	private Department department;
	private double gpa;
	
	public Student(String id, String name, LocalDate dob, List<Course> courses, Department department, double gpa) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.courses = courses;
		this.department = department;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	

}
