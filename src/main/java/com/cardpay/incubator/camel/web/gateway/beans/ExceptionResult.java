package com.cardpay.incubator.camel.web.gateway.beans;

import java.io.Serializable;

public class ExceptionResult extends AbstractResult implements Serializable {

    private static final long serialVersionUID = 2785063300161679416L;

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
