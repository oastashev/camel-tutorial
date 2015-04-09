package com.cardpay.incubator.camel.web.gateway.beans;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> extends AbstractResult {

    public Long total;
    public List<T> records;

    public ListResult() {
        this.records = new ArrayList<>();
    }

    public ListResult(List<T> records) {
        this.setRecords(records);
        this.setSuccess(true);
    }

    public ListResult(Long total, List<T> records) {
        this.total = total;
        this.records = records;
        this.setSuccess(true);
    }

    public void add(T item) {
        this.records.add(item);
    }

    public void setRecords(List<T> records) {
        this.total = (long) records.size();
        this.records = records;
    }

    @Override
    public String toString() {
        return "ListResult{" +
                "total=" + total +
                ", records=" + records +
                "} " + super.toString();
    }
}
