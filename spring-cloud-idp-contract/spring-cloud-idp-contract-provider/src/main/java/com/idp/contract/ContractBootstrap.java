package com.idp.contract;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

/**
 * 合同 Dubbo Spring Cloud Server Bootstrap
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableDistributedTransaction
@MapperScan(basePackages = { "com.idp.contract.mapper" })
public class ContractBootstrap {
	private final static Logger log = LoggerFactory.getLogger(ContractBootstrap.class);
	private final static String SERVER_PORT = "当前Server启动端口:$port";
	private final static String SERVER_PROFILE = "当前Server启动环境:$profile";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ContractBootstrap.class);
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