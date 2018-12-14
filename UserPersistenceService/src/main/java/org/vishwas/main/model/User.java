package org.vishwas.main.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String mailId;
	private int age;
	private int annualIncome;
	private String gender;
	private long phoneNumber;
	private float appliedLoanAmount;
	private String address;
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public float getAppliedLoanAmount() {
		return appliedLoanAmount;
	}
	public void setAppliedLoanAmount(float appliedLoanAmount) {
		this.appliedLoanAmount = appliedLoanAmount;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mailId=" + mailId
				+ ", age=" + age + ", annualIncome=" + annualIncome + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", appliedLoanAmount=" + appliedLoanAmount + ", address=" + address + "]";
	}
	
}
