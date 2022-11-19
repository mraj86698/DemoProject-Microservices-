package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_TBL")
public class Order {
	@Id
	private int orderId;
	private String orderName;
	private int quantity;
	private double price;


//	public Order(OrderDto orderDto) {
//		this.orderName = orderDto.getOrderName();
//		this.quantity = orderDto.getQuantity();
//		this.price = orderDto.getPrice();
//	}
//	public Order(int orderId, OrderDto orderDto) {
//		this.orderId = orderId;
//		this.orderName = orderDto.getOrderName();
//		this.quantity = orderDto.getQuantity();
//		this.price = orderDto.getPrice();
//	}



}
