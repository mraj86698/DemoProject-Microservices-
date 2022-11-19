package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Common.TransactionRequest;
import com.example.demo.Common.TransactionResponse;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderContoller {
	@Autowired
	private OrderService service;

	/**
	 * To Adding Order Details using Post Mapping
	 * @param request
	 * @return
	 */
	@PostMapping("/addOrder")
	public TransactionResponse addOrder( @RequestBody TransactionRequest request){
		return service.createOrder(request);
	}


}
