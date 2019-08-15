package com.idp.saas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idp.saas.service.SixSixLongService;

/**
 * 熔断、降级 演示
 * 
 * @author deyu
 */
@RestController
public class SixSixLongController {

	private final Logger log = LoggerFactory.getLogger(SentinelDemoController.class);

	@Autowired
	private SixSixLongService sixSixLongServiceImpl;

	@GetMapping(value = "/sentineldemo/mayunsay")
	public String mySay() {
		log.info("马云提倡996");
		sixSixLongServiceImpl.sixSixLong("白皮书");
		return "加班996，下班……";
	}

}
