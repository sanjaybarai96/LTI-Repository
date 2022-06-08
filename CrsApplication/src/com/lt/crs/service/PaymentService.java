package com.lt.crs.service;

import java.util.UUID;

import com.lt.crs.bean.Payment;
import com.lt.crs.constants.InputConstants;
import com.lt.crs.constants.Menu;
import com.lt.crs.constants.PaymentType;
import com.lt.crs.dao.PaymentDao;
import com.lt.crs.daoImpl.PaymentDaoImpl;
import com.lt.crs.utils.Utils;

public class PaymentService implements PaymentServiceInterface{

	private PaymentDao paymentDao = new PaymentDaoImpl(); 


	@Override
	public void paymentOption(UUID userId,double amount) {
		System.out.println(String.format(Menu.PaymentOtionMenu,Menu.BackButton));
		InputConstants.optionNumber = InputConstants.sc.nextInt();

		switch (InputConstants.optionNumber) {
		case 1:
			this.cardPayment(userId,amount);
			break;
		case 2:
			//onlinePayment
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	private void cardPayment(UUID userID,double amount) {
		// TODO Auto-generated method stub
		System.out.println("Enter your 12 digit card number");
		String cardNo =  InputConstants.sc.next();
		System.out.println("Enter your CVV");
		String cvv = InputConstants.sc.next();

		System.out.println("Your payment successfully paid");
		String refNumber = Utils.generateRefNumber();
		createPayment(userID,amount,refNumber,PaymentType.Card,true);
	}

	private void createPayment(UUID userId,double amount,String referenceId,PaymentType paymentType, boolean paymentStatus) {
		Payment payment = new Payment();
		payment.setStudentId(userId);
		payment.setAmount(amount);
		payment.setReferenceId(referenceId);
		payment.setPaymentType(paymentType.name());
		payment.setStatus(paymentStatus);
		paymentDao.save(payment);
		
	}

	@Override
	public void cashPayment(UUID userId,double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chequePayment(UUID userId,double amount) {
		// TODO Auto-generated method stub

	}

	public Payment checkPayment(UUID userId) {
		return paymentDao.getPaymentByUserId(userId);
		
	}
}
