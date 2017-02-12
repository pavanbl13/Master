package com.SpringRest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.SpringRest.model.Properties;


@Configuration
@PropertySources
({
@PropertySource(value="classpath:SpringRest.properties"),
@PropertySource(value="classpath:sample.txt", ignoreResourceNotFound=true)
})
public class RestConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public Properties getProperties() throws Exception {
		Properties prop = new Properties();
		prop.setFilePath(env.getProperty("filePath"));
		prop.setFileData(new StringBuffer(env.getProperty("fileData")));
		return prop;
	}
	@Bean
	 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	  return new PropertySourcesPlaceholderConfigurer();
	 }

}
