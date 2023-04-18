package com.sagroup.userservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.sagroup.userservice.config.ConfigFileExternalizationConfig;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.sagroup.userservice.repository")
@EnableDiscoveryClient
@OpenAPIDefinition
public class UserServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);

	public static void main(String[] args) {

		if (ConfigFileExternalizationConfig.createConfigFiles()
				!= ConfigFileExternalizationConfig.CONFIG_FILES_ERROR_STATE) {
			ConfigurableApplicationContext app = new SpringApplicationBuilder(
				UserServiceApplication.class)
					.build().run(ConfigFileExternalizationConfig.enhanceArgs(args));
			Environment env = app.getEnvironment();
			String protocol = "http";
			if (env.getProperty("server.ssl.key-store") != null) {
				protocol = "https";
			}
			LOGGER.info("\n----------------------------------------------------------\n\t"
							+ "Application '{}' is running! Access URLs:\n\t"
							+ "Local: \t\t{}://localhost:{}\n\t"
							+ "Profile(s): \t{}\n----------------------------------------------------------",
					env.getProperty("spring.application.name"),
					protocol,
					env.getProperty("server.port"),
					env.getActiveProfiles());
		} else {
			LOGGER.error("Please proceed to manually creation of configuration files!");
		}
	}

}
