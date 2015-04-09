package com.cardpay.incubator.camel.web.gateway.beans;

public abstract class AbstractResult {

    private Boolean success = false;
    private Integer errorCode = 0;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "AbstractResult{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                "}";
    }
}
