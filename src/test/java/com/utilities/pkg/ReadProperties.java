package com.utilities.pkg;

import org.apache.xmlbeans.SystemProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private Properties prop = new Properties();
    private String value = null;


    public String readProps (String key) throws IOException {
        String directory = SystemProperties.getProperty("user.dir") + "//src//test//resources//Properties";
        FileInputStream fs = new FileInputStream(directory+"//general.properties//");
        prop.load(fs);
        value = prop.getProperty(key);
        return value;
    }
}
