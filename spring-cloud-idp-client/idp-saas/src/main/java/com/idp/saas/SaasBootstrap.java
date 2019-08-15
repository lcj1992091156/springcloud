package com.idp.saas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

/**
 * Dubbo Spring Cloud Server Bootstrap
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan({"com.idp.saas","com.codingapi.txlcn.tracing.dubbo"})
@EnableDistributedTransaction
public class SaasBootstrap {
	private final static Logger log = LoggerFactory.getLogger(SaasBootstrap.class);
	private final static String SERVER_PORT = "当前Server启动端口:$port";
	private final static String SERVER_PROFILE = "当前Server启动环境:$profile";
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SaasBootstrap.class);
		ConfigurableEnvironment environment = context.getEnvironment();
		if (environment != null) {
			log.info("-------------------------------------------------------------------------");
			log.info(SERVER_PORT.replace("$port", String.valueOf(environment.getProperty("port"))));
			log.info(SERVER_PROFILE.replace("$profile",
					String.valueOf(context.getEnvironment().getActiveProfiles()[0])));
			log.info("-------------------------------------------------------------------------");
		}
	}

}