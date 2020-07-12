package commonUtils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadWriteFile {
    private static FileOutputStream output;
    private static Properties prop;
    private static PropertiesConfiguration prof;

    public static void insertUpdatedTempValueIntoConfigFile(String Key, String Value) throws IOException, ConfigurationException {
        prof = new PropertiesConfiguration("config.properties");
        prof.setProperty(Key, Value);
        prof.save();
    }

    public static String getTempValueFromConfigFile(String Key) throws IOException {
        InputStream input = new FileInputStream("config.properties");

        prop = new Properties();

        // load a properties file
        prop.load(input);
        String value = prop.getProperty(Key);
        input.close();
        return value;
    }

    public static void insertTempValueIntoConfigFile1(Double WebSiteTempValue) throws IOException, ConfigurationException {
        output = new FileOutputStream("config.properties", true);
        prop = new Properties();
        // set the properties value
        prop.setProperty("webSite.tempValue", String.valueOf(WebSiteTempValue));
        // save properties to project root folder
        prop.store(output, null);
        output.close();
    }
}
