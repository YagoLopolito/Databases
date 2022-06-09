package com.solvd.Uver.util;

import com.solvd.Uver.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPropertiesUtil {
    private static final Logger log = LogManager.getLogger(DBPropertiesUtil.class);

    private static final Properties properties = new Properties();
    private static final DBPropertiesUtil dbPropertiesUtil = new DBPropertiesUtil();

    private DBPropertiesUtil() {
        try {
            properties.load(new FileReader("src/main/resources/db.properties.properties"));
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }


}