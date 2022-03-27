package com.application.modul3.account.dto;

import java.util.Set;

public class AccountDTO {
	private Integer id;
	private String iban;
	private Integer ballance;
	private String bank;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Integer getBallance() {
		return ballance;
	}
	public void setBallance(Integer ballance) {
		this.ballance = ballance;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

}
