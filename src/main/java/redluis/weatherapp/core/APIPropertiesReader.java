package redluis.weatherapp.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIPropertiesReader {
    private static FileInputStream fin;
    private static Properties properties = new Properties();

    public static APIProperties readProperties() throws IOException {
            fin = new FileInputStream("src/main/resources/api.properties");
            properties.load(fin);

            String API_KEY = properties.getProperty("API_KEY");
            String API_URL_TEMPLATE = properties.getProperty("API_URL_TEMPLATE");

            return new APIProperties(API_KEY, API_URL_TEMPLATE);
    };
}
