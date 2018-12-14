package org.vishwas.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Account {
	@Id
	private long accountNumber;
	private int outStanding;
	@OneToOne
	private User user;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getOutStanding() {
		return outStanding;
	}
	public void setOutStanding(Integer outStanding) {
		this.outStanding = outStanding;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", outStanding=" + outStanding + ", user=" + user + "]";
	}
}
