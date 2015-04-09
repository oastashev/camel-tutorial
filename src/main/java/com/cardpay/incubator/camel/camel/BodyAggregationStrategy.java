package com.cardpay.incubator.camel.camel;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;

public class BodyAggregationStrategy extends AbstractListAggregationStrategy<Object> {

    @Override
    public Object getValue(Exchange exchange) {
        return exchange.getIn().getBody(Object.class);
    }

}
