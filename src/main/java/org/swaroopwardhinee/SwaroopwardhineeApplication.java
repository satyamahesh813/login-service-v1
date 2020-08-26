package org.swaroopwardhinee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.Async;

@Async
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("org.swaroopwardhinee.mappers")
@EnableFeignClients
public class SwaroopwardhineeApplication extends SpringBootServletInitializer{

	private static final Logger logger = LogManager.getLogger(SwaroopwardhineeApplication.class);

	public static void main(String[] args) {
		logger.debug("Jar Creation started from Main Class...");
		SpringApplication.run(SwaroopwardhineeApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.debug("War Creation started from Main Class...");
		return builder.sources(SwaroopwardhineeApplication.class);
	}

}
