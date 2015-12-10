package com.sagar.restgwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class RestGWTController {
	@RequestMapping(value = "/loadInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody TestEntity handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestEntity confirmation = new TestEntity();
		confirmation.test = "Hello";
		System.out.println("hit server");
		return confirmation;
	}
}