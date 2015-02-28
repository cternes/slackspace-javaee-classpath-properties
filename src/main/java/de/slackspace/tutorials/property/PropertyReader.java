package de.slackspace.tutorials.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * This class is a producer class for properties.
 * The class will read property files from the classpath and provide 
 * the properties found in the files as a Properties class.
 *
 */
@Dependent
public class PropertyReader {

	@Produces
	@PropertiesFromFile
	public Properties provideServerProperties(InjectionPoint ip) {
		//get filename from annotation
		String filename = ip.getAnnotated().getAnnotation(PropertiesFromFile.class).value();
		return readProperties(filename);
	}
	
	/**
	 * Reads a properties file from the classpath and returns its properties
	 * as a class.
	 * 
	 * @param fileInClasspath a file in the classpath
	 * @return the properties in the file
	 */
	private Properties readProperties(String fileInClasspath) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileInClasspath);
		
		try {
			Properties properties = new Properties();
			properties.load(is);
			return properties;
		} catch (IOException e) {
			System.err.println("Could not read properties from file " + fileInClasspath + " in classpath. " + e);
		}
		
		return null;
	}
}
