package com.cardpay.incubator.camel.dao.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoIpDataBean implements Serializable {

    private static final long serialVersionUID = 8288706704538128381L;

    public Date added;
    public String ip;
    public String country;
    public String city;
    public String service;

    public GeoIpDataBean() {
        //
    }

    public GeoIpDataBean(Date added, String ip, String country, String city, String service) {
        this.added = added;
        this.ip = ip;
        this.country = country;
        this.city = city;
        this.service = service;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "GeoIpDataBean{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
