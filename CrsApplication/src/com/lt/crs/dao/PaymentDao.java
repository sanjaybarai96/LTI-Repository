package com.lt.crs.dao;

import java.util.UUID;

import com.lt.crs.bean.Payment;

public interface PaymentDao {

	void save(Payment payment);

	Payment getPaymentByUserId(UUID userId);
}
