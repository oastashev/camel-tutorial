package com.cardpay.incubator.camel.web.gateway;


import com.cardpay.incubator.camel.web.gateway.beans.ExceptionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    ExceptionResult handleAllException(Exception e) {
        log.error(e.getMessage(), e);
        ExceptionResult result = new ExceptionResult();
        result.setSuccess(false);
        result.setError("Internal error.");
        return result;
    }

}
