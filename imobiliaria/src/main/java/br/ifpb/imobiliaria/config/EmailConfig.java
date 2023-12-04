package br.ifpb.imobiliaria.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailConfig {
    private static final String PROPERTIES_FILE = "/mail.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try(InputStream input = EmailConfig.class.getResourceAsStream(PROPERTIES_FILE)){
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Properties getProps(){
        return properties;
    }

}
