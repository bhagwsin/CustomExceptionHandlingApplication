package com.example.demo.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
/*
 * @PropertySource({ "classpath:/config/module1.properties",
 * "classpath:/config/module2.properties" })
 */
public class ReadExternalProperty {
	
	  @Bean 
	  public PropertySourcesPlaceholderConfigurer  propertySourcesPlaceholderConfigurer() {
	  
	  PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer= new PropertySourcesPlaceholderConfigurer();
	  propertySourcesPlaceholderConfigurer.setLocation(new FileSystemResource("D:/config/module1.properties"));
	  
	  return propertySourcesPlaceholderConfigurer; 
	  
	  }
	 

	
}
