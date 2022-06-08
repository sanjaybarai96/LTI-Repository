package com.lt.crs.constants;

public enum PaymentType {

	Card("card"),
	Online("online"),
	Cash("cash"),
	Scholarship("scholarship");

	private String paymentType;

	PaymentType(String paymentType){
		this.paymentType = paymentType;
	}

	public PaymentType getPaymentType(String paymentType) {
		for (PaymentType e : values()) {
			if (e.paymentType.equals(paymentType)) {
				return e;
			}
		}
		return null;
	}
}
