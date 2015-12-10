package com.sagar.restgwt.client;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.client.GWT;

public class TestPojo {
	public Long id;
	public String test;
	public String test2;
	/**
     * Example of how to create an instance of a JsonEncoderDecoder for a data
     * transfer object.
     */
    public interface TestPojoJED extends JsonEncoderDecoder<TestPojo> {}
    
//    @Override
//    public String toString() {
//        if (GWT.isClient()) {
//            TestPojoJED jed = GWT.create(TestPojoJED.class);
//            return jed.encode(this).toString();
//        }
//        return super.toString();
//    }
}
