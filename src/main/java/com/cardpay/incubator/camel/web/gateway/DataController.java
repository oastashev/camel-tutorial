package com.cardpay.incubator.camel.web.gateway;

import com.cardpay.incubator.camel.dao.beans.GeoIpDataBean;
import com.cardpay.incubator.camel.dao.GeoIpDao;
import com.cardpay.incubator.camel.web.gateway.beans.ListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/gateway/data")
public class DataController {

    @Autowired
    GeoIpDao dao;

    @RequestMapping(value = "/geoip", method = RequestMethod.GET)
    @ResponseBody
    public ListResult<GeoIpDataBean> list(@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "20") Integer pageSize,
                                          @RequestParam(required = false, defaultValue = "ip") String sortColumn,
                                          @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        return new ListResult<>(dao.count(), dao.query(page, pageSize, sortColumn, sortOrder));
    }

}
