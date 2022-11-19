package com.example.demo.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderDto {
	@NotNull(message="OrderName is Not Null")
	private String orderName;
	@NotNull(message="Price is Not Null")
	private double price;
	@NotNull(message="Quantity is Not Null")
	private int quantity;


}
