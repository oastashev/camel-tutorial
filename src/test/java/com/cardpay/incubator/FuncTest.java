package com.cardpay.incubator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FuncTest {

    private static final Logger LOG = LoggerFactory.getLogger(FuncTest.class);

    static File TEMP_DIR = new File(System.getProperty("user.dir") + "/target/!camel-tutorial");

    static {
        if (!TEMP_DIR.exists() && !TEMP_DIR.mkdirs()) {
            throw new RuntimeException("Temp folder has been failed to create.");
        }
        LOG.info("{}", TEMP_DIR);

        System.setProperty("camelTutorialDir", TEMP_DIR.getAbsolutePath());
    }
}
