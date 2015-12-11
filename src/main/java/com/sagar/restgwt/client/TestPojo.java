package com.sagar.restgwt.client;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.client.GWT;

public class TestPojo {
	public Long id;
	public String test;
	public String test2;

	public TestPojo() {
		super();
	}
	public TestPojo(Long id, String string, String string2) {
		this.id = id;
		this.test = string;
		this.test2 = string2;
	}

	public Long getId() {
		return id;
	}
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
    
    @Override
    public String toString() {
    	return this.id + " " + this.test + " " + this.test2 ;
    }
}
