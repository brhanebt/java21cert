package streaming.hr;


public class Employee {
	
	private String employeeId;
	private String employeeName;
	private String department;
	private String role;
	private Double salary;
	private String supervisor;
	public Employee(String employeeId, String employeeName, String department, String role, Double salary, String supervisor) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
		this.role = role;
		this.salary = salary;
		this.supervisor = supervisor;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	@Override
	public String toString() {
		return "\nEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department + ", role=" + role
				+ ", salary=" + salary + ", supervisor=" + supervisor + "]";
	}

}
