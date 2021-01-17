package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* Read data from config.properties file */
public class Configuration {
	// variable that will include one instance of the class
	private static Configuration configInstance = null;
	private static Properties prop;

	// private constructor
	private Configuration() {
		try (InputStream input = new FileInputStream(".\\src\\test\\resources\\data\\config.properties")) {
			prop = new Properties();
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Load a properties file and retrieve the property value.
	public static String readProperty(String key) {
		String value = "";
		if (configInstance == null) {
			configInstance = new Configuration();
		}
		// get the property value
		value = prop.getProperty(key);
		return value;
	}
}
