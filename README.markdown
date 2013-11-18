# Jersey REST Server Template
## Description

The goal of this template is to have a basic Jersey server, ready to be run in Tomcat.
The Spring configuration is based on annotations, no XML context files!
The server can respond with XML or JSON.

It is not easy to find correct versions of jersey-server and jersey-spring3 that work well together.
For newer versions of Jersey (3.1, 3.1.1) I could not find a correct Spring integration bundle.
As long as the integration problems persist it is impossible to use a newer version of Jersey ...

I can only get it working with Jackson JSON not with Jettison.

## Features

* Standard Java web application.
* REST services.
* Spring configuration (annotation based).

## Usage
### Adding a service

* Don't forget to put the packages that Jersey has to scan in the web.xml as wel (servlet parameter).  It is only
necessary if you want to add other packages that are not subpackages of the main package com.sdicons.
* Just add the service with correct annotations, Jersey will automatically find it. You don't need to register
the service class anywhere. It cannot be simpler. The service class must have a @Path annotation as well, otherwise
the Jersey scanner will not find the resource.

## Notes

* At least Java 1.6 needed for the Spring annotations.
* In Spring +3.1 @ComponentScan becomes available, so you do not need to create the beans explicitly.
* You should run it as a Tomcat application. It was tested with Tomcat 6 and 7.

## Links

* Intro page: ["http://localhost:8080/"](http://localhost:8080/)
* REST service: ["http://localhost:8080/rest/hello?name=Bruno"](http://localhost:8080/rest/hello?name=Bruno) (parameter is optional)
* WADL: ["http://localhost:8080/rest/application.wadl"](http://localhost:8080/rest/application.wadl)

## Files

* **/README.txt**: This file
* **/pom.xml**: The Maven configuration file.
   1. Spring core (main Spring functionality) + web (for the context listener that creates the global Spring context).
   2. Jersey Server + Jersey Spring integration.
   3. Jackson for JSON rendering trough JAXB annotations.
* **/src/main/java/com/sdicons/AppConfig.java**: The Spring configuration class replacing the XML configuration. It produces all the application instances.
* **/src/main/java/com/sdicons/RestService.java**: A plain JAX-RS 'hello' service..
* **/src/main/webapp/WEB-INF/web.xml**: Standard Java web application.
   1.  Jersey servlet + parameter to scan package for resources.
   2.  Spring context setup to pick up our AppConfig class to initialize the context.

## Conclusions

Jersey automatically finds resources and providers in the registered packages. So you don't have to register the
classes in different places.

Jersey currently does not integrate well with Spring. You could stick to the version in this POM, but it can be very
frustrating if you want to upgrade version to get  a bugfix or a neew feature and you cannot do it because the
Spring injection wont work anymore. This is a good reason not to use Jersey for a product that will be in use for
a number of years.

I worked very hard to integrate Jettison as well, but I did not succeed. There was no way to get the Jettison
integration working. This should be an easy task to do. I think that the Jersey project is aiming towards the
JSON-P which will be in Java 8+. It is unfriendly towards older, existing projects.

