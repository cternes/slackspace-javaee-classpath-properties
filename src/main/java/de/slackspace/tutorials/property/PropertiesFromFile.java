package de.slackspace.tutorials.property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * This annotation can be used to inject a properties file into 
 * another CDI managed class.
 *
 */
@Qualifier
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertiesFromFile {

	/**
	 * This value must be a properties file in the classpath.
	 */
	@Nonbinding
    String value() default "config.properties";
}
