package com.sagar.restgwt.client;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.client.GWT;

public class OrderConfirmation {
    public String message;
    public Long ready_time;
    /**
     * Example of how to create an instance of a JsonEncoderDecoder for a data
     * transfer object.
     */
    public interface OrderConfirmationJED extends JsonEncoderDecoder<OrderConfirmation> {
    }
    @Override
    public String toString() {
        if (GWT.isClient()) {
            OrderConfirmationJED jed = GWT.create(OrderConfirmationJED.class);
            return jed.encode(this).toString();
        }
        return super.toString();
    }
}
