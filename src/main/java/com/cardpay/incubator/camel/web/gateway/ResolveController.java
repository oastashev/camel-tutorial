package com.cardpay.incubator.camel.web.gateway;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/gateway/resolve")
public class ResolveController {

    @EndpointInject(uri = "direct:resolveIp")
    public ProducerTemplate resolveIp;

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> resolve(@RequestParam String ip) {
        return (Map<String, String>) resolveIp.requestBody(ip);
    }

}
