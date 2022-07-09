package Nouns;

import java.time.*;

public class Reimbursement {
	
	private int empID;
	private int reqID;
	private String username;
	public String fName;
	public String lName;
	private float requestAmt;
	private ReimbursementStatus pStatus = ReimbursementStatus.PENDING;
	private String status = pStatus.name();
	private LocalDateTime submitTime;
	
	//private Employee employee;
	
	public void setPK_ID(int empID) {
		this.empID = empID;
	}
	
	public int getPK_ID() {
		return empID;
	}
	
	public void setReqID(int reqID) {
		this.reqID=reqID;
	}
	
	public int getReqID() {
		return reqID;
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
	
	public void setReqAmt(float requestAmt) {
		this.requestAmt=requestAmt;
	}
	
	public float getReqAmt() {
		return requestAmt;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
