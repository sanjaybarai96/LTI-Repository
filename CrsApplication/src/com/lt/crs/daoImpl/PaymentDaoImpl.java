package com.lt.crs.daoImpl;

import java.util.UUID;

import com.lt.crs.bean.Payment;
import com.lt.crs.constants.DataCollections;
import com.lt.crs.dao.PaymentDao;

public class PaymentDaoImpl implements PaymentDao{

	@Override
	public void save(Payment payment) {
		DataCollections.payments.add(payment);
	}

	@Override
	public Payment getPaymentByUserId(UUID userId) {
		return DataCollections.payments.stream().filter(payment->payment.getStudentId().equals(userId)).findAny().orElse(null);
		
	}

}
