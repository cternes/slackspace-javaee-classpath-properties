# Injecting properties in Java EE applications

## Run with a Java EE compliant application server

You have to deploy the war-file manually. You can generate the war-file by typing on the command line:

	mvn clean compile package

Now you will find the war-file in the target directory of the project. 

Drop it into your favorite Java EE compliant application server and you're ready to test it.

While deploying the application you should see some log messages in the log file of your application server:

	==Starting application==
	Found configuration config.properties:
	Key: serverIp value: 192.168.0.1
	Key: serverName value: JEE Sample
	Found configuration other.properties:
	Key: A value: 123456
	Key: C value: 456789
	Key: B value: 789123

You can also access a basic servlet which will print out the properties of _config.properties_ file at [http://localhost:8080/javaee-classpath-properties/](http://localhost:8080/javaee-classpath-properties/)