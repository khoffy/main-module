package com.sagroup.registrationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.sagroup.registrationservice.config.ConfigFileExternalizationConfig;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceApplication.class);

	public static void main(String[] args) {
		if (ConfigFileExternalizationConfig.createConfigFiles()
				!= ConfigFileExternalizationConfig.CONFIG_FILES_ERROR_STATE) {
			ConfigurableApplicationContext app = new SpringApplicationBuilder(
					RegistrationServiceApplication.class)
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
