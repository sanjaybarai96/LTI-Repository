package com.lt.src.repository;


import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.Payment;

@Repository
public class PaymentDaoImpl {
	
	public void save(Payment payment) {
		DataCollections.payments.add(payment);
	}

	public Payment getPaymentByUserId(UUID userId) {
		return DataCollections.payments.stream().filter(payment->payment.getStudentId().equals(userId)).findAny().orElse(null);
		
	}

}
