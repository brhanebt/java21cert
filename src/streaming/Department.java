package streaming;

public class Department {
	private String deptId;
	private String deptName;
	private String location;
	
	public Department(String deptId, String deptName, String location) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
