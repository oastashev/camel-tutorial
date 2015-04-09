package com.cardpay.incubator;

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

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeoIP_1_FuncTest.class)
@Configuration
@ComponentScan({"com.cardpay.incubator.camel"})
@ImportResource({
        "classpath:application-config.xml",
        "classpath:/camel/camel-context_1.xml",
        "classpath:/camel/service-telize.xml"
})
public class GeoIP_1_FuncTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @EndpointInject(uri = "direct:resolveIpByTelize")
    public ProducerTemplate resolveIpByTelize;

    @Test
    public void testTelize() {
        // given
        String ip = "109.126.9.66";

        // when
        // then
        log.info("{}", resolveIpByTelize.requestBody(ip));
    }

}
