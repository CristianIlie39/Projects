package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"persistence.dao", "business.service", "entryPoint"})
public class SpringConfiguration {

}
