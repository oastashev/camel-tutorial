package com.cardpay.incubator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GeoIP_9_FuncTest.class)
@Configuration
@ComponentScan({"com.cardpay.incubator.camel"})
@ImportResource({
        "classpath:application-config.xml",
        "classpath:application-db.xml",
        "classpath:/camel/test9/camel-context.xml",
        "classpath:/camel/test9/service-stub.xml",
        "classpath:/camel/test9/geoip.xml"
})
public class GeoIP_9_FuncTest extends FuncTest {

    @Test
    public void testProcessFile() throws InterruptedException, IOException {
        File f = new File(TEMP_DIR, System.currentTimeMillis() + ".txt");
        try (PrintWriter out = new PrintWriter(f)) {
            Random rnd = new Random();
            for (int i = 0; i < 100; i++) {
                out.println(String.format("%d.%d.%d.%d", rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
            }
        }

        while (f.exists()) {
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
    }

}
