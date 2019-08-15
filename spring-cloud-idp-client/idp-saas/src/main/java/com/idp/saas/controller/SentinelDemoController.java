package com.idp.saas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 熔断演示
 * 
 * @author deyu 2019-7-12
 */
@RestController
public class SentinelDemoController {
	private final Logger log = LoggerFactory.getLogger(SentinelDemoController.class);

	@GetMapping(value = "/sentineldemo/hello")
	@SentinelResource(value = "sentineldemo", blockHandler = "exceptionHandler")
	public String hello() {
		log.info("sentinel hello ………………");
		return "Hello Sentinel";
	}

	public String exceptionHandler(BlockException ex) {
		log.info("开始限流啦!!!!");
		return "老铁 你装逼的实力已突破天际,收了神通吧.";
	}

}
