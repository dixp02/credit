package org.vishwas.creditCheck.model;

public class UserEligibilityDetails {
	
	private String firstName;
	private String lastName;
	private int loanAmount;
	private int outstandingBalance;
	private String eligibilityStatus;
	private String userExists;
	
	public String getUserExists() {
		return userExists;
	}
	public void setUserExists(String userExists) {
		this.userExists = userExists;
	}
	public String getEligibilityStatus() {
		return eligibilityStatus;
	}
	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(int outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
}
