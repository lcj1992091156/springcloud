package com.idp.saas.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.idp.saas.service.SixSixLongService;

import lombok.extern.slf4j.Slf4j;

/**
 * SixSixLongService-熔断降级
 * 
 * @author deyu
 */
@Slf4j
@Service
public class SixSixLongServiceImpl implements SixSixLongService {

	/**
	 * 注意Sentinel控制台中,关于熔断、降级的规则配置。规则冲突的情况下 熔断优先级高于降级
	 */
//	@SentinelResource(value = "sixsixlong", blockHandler = "sixblockHandler") 熔断
	@SentinelResource(value = "sixsixlong", fallback = "sixBackHandler")
	public void sixSixLong(String msg) {
		log.info("执行马老板的996……");
		throw new RuntimeException("累的不行了");
	}

	public void sixblockHandler(String msg, BlockException ex) {
		log.info("熔断之后669");
	}

	public void sixBackHandler(String msg) {
		log.info("降级之后995");
	}

}
