package com.cardpay.incubator;

import com.cardpay.incubator.camel.dao.beans.GeoIpDataBean;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeoIP_2_FuncTest.class)
@Configuration
@ComponentScan({"com.cardpay.incubator.camel"})
@ImportResource({
        "classpath:application-config.xml",
        "classpath:/camel/camel-context.xml",
        "classpath:/camel/service-telize.xml",
        "classpath:/camel/service-ipinfo.xml",
        "classpath:/camel/geoip_2.xml"
})
public class GeoIP_2_FuncTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @EndpointInject(uri = "direct:resolveIpByTelize")
    public ProducerTemplate resolveIpByTelize;

    @EndpointInject(uri = "direct:resolveIpByIpinfo")
    public ProducerTemplate resolveIpByIpinfo;

    @EndpointInject(uri = "direct:resolveIp")
    public ProducerTemplate resolveIp;

    @Test
    public void testTelize() {
        // given
        // when
        // then
        log.info("{}", resolveIpByTelize.requestBody("109.126.9.66"));
    }

    @Test
    public void testIpInfo() {
        // given
        // when
        // then
        log.info("{}", resolveIpByIpinfo.requestBody("109.126.9.66"));
    }

    @Test
    public void testResolveIp() {
        log.info("{}", resolveIp.requestBody("109.126.9.66"));
        log.info("{}", resolveIp.requestBody("88.198.26.2"));
        log.info("{}", resolveIp.requestBody("8.8.8.8"));
    }

}
