package com.web.entity;

import java.io.Serializable;

/**
 * 银行表实体类
 * @author Administrator
 *
 */
public class Bank implements Serializable {
	/**
	 * 银行编号
	 */
	private int bankId;
	/**
	 * 银行地址名
	 */
	private String bankName;
	
	public Bank() {
		super();
	}
	
	public Bank(int bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	/**
	 * @return the bankId
	 */
	public int getBankId() {
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
