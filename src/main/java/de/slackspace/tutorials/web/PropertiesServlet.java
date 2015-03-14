package de.slackspace.tutorials.web;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.slackspace.tutorials.property.PropertiesFromFile;

/**
 * A servlet that prints out the properties from config.properties file.
 *
 */
@WebServlet({"/PropertiesServlet", ""})
public class PropertiesServlet extends HttpServlet {

	@Inject
	@PropertiesFromFile
	public Properties configProperties;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/plain");
		
		ServletOutputStream writer = resp.getOutputStream();
		writer.println("Properties");
		writer.println("");
		
		for (Entry<Object, Object> entry : configProperties.entrySet()) {
			writer.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
