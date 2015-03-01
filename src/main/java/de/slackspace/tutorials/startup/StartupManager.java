package de.slackspace.tutorials.startup;

import java.util.Enumeration;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import de.slackspace.tutorials.property.PropertiesFromFile;

/**
 * This class will be run once on startup of the application.
 * Two properties files will be injected by an annotation and the properties from
 * the files will be printed out on startup. 
 *
 */
@Startup
@Singleton
public class StartupManager {

	@Inject
	@PropertiesFromFile("config.properties")
	Properties configProperties;
	
	@Inject
	@PropertiesFromFile("other.properties")
	Properties otherProperties;
	
	@PostConstruct
	public void init() {
		System.out.println("==Starting application==");
		
		System.out.println("Found configuration config.properties:");
		printProperties(configProperties);
		
		System.out.println("Found configuration other.properties:");
		printProperties(otherProperties);
	}

	/**
	 * Prints out all properties from a given Properties class.
	 */
	private void printProperties(Properties p) {
		Enumeration<Object> keyEnum = p.keys();
		while(keyEnum.hasMoreElements()) {
			String key = (String) keyEnum.nextElement();
			System.out.println("Key: " + key + " value: " + p.getProperty(key));
		}
	}
}
