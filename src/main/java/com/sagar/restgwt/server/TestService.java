package com.sagar.restgwt.server;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.restgwt.shared.Routing;

@RestController()
public class TestService {
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public @ResponseBody void test() {
		System.out.println("Hit server for getting __ test");
	}
	@RequestMapping(value = Routing.TestService.getInfo, method = RequestMethod.GET)
	public @ResponseBody TestEntity getInfo() {
		TestEntity test = new TestEntity();
		test.setId(1L);
		test.setTest("Hello");
		test.setTest2("Hello");
		System.out.println("Hit server for getting _1");
		return test;
	}
	@RequestMapping(value = Routing.TestService.setInfo, method = RequestMethod.POST)
	public @ResponseBody int setInfo(@RequestBody TestEntity test) {
		System.out.println("Hit server for setting _1");
		System.out.println(test.getId() + " " + test.getTest() + " " + test.getTest2());
		return 1;
	}
}