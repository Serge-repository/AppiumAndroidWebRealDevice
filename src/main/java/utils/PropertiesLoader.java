package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties = new Properties();

    public String getRealDeviceUdidProperty(String key) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "RealDeviceUDID.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties.getProperty(key);
    }
}
