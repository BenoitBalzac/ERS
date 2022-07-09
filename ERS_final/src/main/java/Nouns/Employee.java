package Nouns;

public class Employee {
	
	public int empID;
	public String username;
	public String fName;
	public String lName;
	public String password;
	public EmployeeType role=EmployeeType.EMPLOYEE;
	
	public void setID(int empID) {
		this.empID = empID;
	}

	public int getID() {
		return empID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getFName() {
		return fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	

}
