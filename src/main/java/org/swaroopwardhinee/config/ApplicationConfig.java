package org.swaroopwardhinee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource("${customer.properties}")})
public class ApplicationConfig {
	
}
