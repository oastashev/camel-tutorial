package com.cardpay.incubator.camel.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeoIpDaoFuncTest.class)
@Configuration
@ComponentScan({"com.cardpay.incubator.camel"})
@ImportResource({
        "classpath:application-config.xml",
        //"classpath:application-db.xml",
        "classpath:application-db-spied.xml",
})
@DirtiesContext
public class GeoIpDaoFuncTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    GeoIpDao dao;

    @Test
    public void testCount() {
        // given

        // when
        log.info("{}", dao.count());
        // then
    }

    @Test
    public void testQuery() {
        // given

        // when
        log.info("{}", dao.query(1, 20, "ip", "desc"));
        // then
    }

}