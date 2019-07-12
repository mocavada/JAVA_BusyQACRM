package com.busyqa.crm;

import com.busyqa.crm.model.util.FileStorageProperties;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class CRMApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(CRMApplication.class);


	// EMAIL BEAN AUTOWIRING
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CRMApplication.class);
	}


	public static void main(String[] args) throws Exception {
		LOG.info("STARTING THE APPLICATION");


		SpringApplication.run(CRMApplication.class, args);
		LOG.info("APPLICATION FINISHED");

		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Version version = om.version();
		System.out.println(version);



	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}
