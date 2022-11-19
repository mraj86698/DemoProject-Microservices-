package com.example.demo.Common;

import com.example.demo.Model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
