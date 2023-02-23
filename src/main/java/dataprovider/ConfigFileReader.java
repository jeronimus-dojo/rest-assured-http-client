package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private static ConfigFileReader configfileReader;

    private ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/configuration.properties";
        try {
            reader = new BufferedReader((new FileReader(propertyFilePath)));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigFileReader getInstance() {
        if (configfileReader == null) {
            configfileReader = new ConfigFileReader();
        }
        return configfileReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base_url");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_url not specified in configuration.properties file.");
    }

    public String getWritePayloadLocation() {
        String WritePayloadLocation = properties.getProperty("write_payload_location");
        if (WritePayloadLocation != null) return WritePayloadLocation;
        else throw new RuntimeException("write_payload_location not specified in configuration.properties file.");
    }
}
