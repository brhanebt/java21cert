package streaming.hr;

import java.util.List;

public class Department {
	
	private String departmentId;
	private String departmentName;
	private String departmentManager;
	private List<Employee> employees;
	
	public Department(String departmentId, String departmentName, String departmentManager, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentManager = departmentManager;
		this.employees = employees;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(String departmentManager) {
		this.departmentManager = departmentManager;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "\nDepartment [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentManager="
				+ departmentManager + ", employees=" + employees + "]";
	}

}
