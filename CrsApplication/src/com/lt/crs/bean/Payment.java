package com.lt.crs.bean;

import java.util.UUID;

/**
 * @author user215
 *Payment bean contains payment member
 */
public class Payment {

	private String referenceId;
	private UUID studentId;
	private double amount;
	private boolean status;
	private String paymentType;
	
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String toString() 
	{
		return "paymentType[refernceId ," + referenceId + "studentId ," + studentId +
				"amount ," + amount + "status ,"+ status +"paymentType ,"+ paymentType +"]";
		
	}
}
