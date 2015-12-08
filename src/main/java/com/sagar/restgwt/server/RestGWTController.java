package com.sagar.restgwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.restgwt.client.OrderConfirmation;

@Controller
public class RestGWTController {
	@RequestMapping(value = "/loadInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody OrderConfirmation handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GreetingServiceEndpoint endpoint = greetingService.getGreetingServiceEndpointPort();
		OrderConfirmation confirmation = new OrderConfirmation();
		//confirmation.message = endpoint.sayHello();
		confirmation.message = "Hello";
		confirmation.ready_time = System.currentTimeMillis() + 1000 * 60 * 30;
		System.out.println("hit server");
		return confirmation;
	}
}