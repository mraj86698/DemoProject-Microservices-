package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Common.Payment;
import com.example.demo.Common.TransactionRequest;
import com.example.demo.Common.TransactionResponse;
import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private RestTemplate restTemplate;

	public TransactionResponse createOrder(TransactionRequest request) {
		/**
		 * Integration for Order and Payment Details
		 */
		Order order = request.getOrder();
		System.out.println(order);
		Payment payment = request.getPayment();
		payment.setOrderId(order.getOrderId());
		payment.setAmount(order.getPrice());
		System.out.println(payment);
		//rest call
		Payment paymentResponse=restTemplate.postForObject("http://localhost:8094/payment/doPayment",payment,Payment.class);
		System.out.println(paymentResponse);
		String message = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";

		orderRepo.save(order);
		 return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);

	}

}
