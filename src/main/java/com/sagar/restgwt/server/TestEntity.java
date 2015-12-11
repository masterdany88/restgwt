package com.sagar.restgwt.server;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TestEntity {
	@NotNull(message="ID nie może być puste")
	private Long id;
	@Size(min=2, max=10)
	private String test;
	private String test2;
	
	
	@NotNull(message="ID nie może być puste")
	public Long getId() {
		return id;
	}
	@NotNull(message="ID nie może być puste")
	public void setId(Long id) {
		this.id = id;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	
	
}
