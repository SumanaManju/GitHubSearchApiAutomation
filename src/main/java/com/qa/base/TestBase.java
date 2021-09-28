package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

        public int RESPONSE_STATUS_CODE_200 = 200;
        public int RESPONSE_STATUS_CODE_304 = 304;
        public int RESPONSE_STATUS_CODE_422 = 422;
        public int RESPONSE_STATUS_CODE_503 = 503;

        public Properties prop;

        public TestBase() {
            try {
                prop = new Properties();
                FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
