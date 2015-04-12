package com.cardpay.incubator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeoIP_3_FuncTest.class)
@Configuration
@ComponentScan({"com.cardpay.incubator.camel"})
@ImportResource({
        "classpath:application-config.xml",
        "classpath:/camel/camel-context.xml",
        "classpath:/camel/service-telize.xml",
        "classpath:/camel/service-ipinfo.xml",
        "classpath:/camel/geoip_3.xml"
})
@DirtiesContext
public class GeoIP_3_FuncTest extends FuncTest {

    @Test
    public void testProcessFile() throws InterruptedException, IOException {
        File f = new File(TEMP_DIR, System.currentTimeMillis() + ".txt");
        try (PrintWriter out = new PrintWriter(f)) {
            out.println("109.126.9.66");
            out.println("8.8.8.8");
        }

        while (f.exists()) {
            Thread.sleep(2000);
        }
    }

}
