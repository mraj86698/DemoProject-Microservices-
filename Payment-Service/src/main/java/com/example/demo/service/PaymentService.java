package com.example.demo.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Payment;
import com.example.demo.Repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	RestTemplate restTemplate;

	public Payment doPayment(Payment payment) {

		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	/**
	 * Api Should be Third Party payment Gateway(paypal,paytm)
	 * @return
	 */
	public String paymentProcessing() {
		return new Random().nextBoolean()?"Sucess":"Failure";
	}
	 public Payment findByOrderId(int orderId) {
		 return paymentRepo.findByOrderId(orderId);

	    }

}