package com.idp.contract.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.idp.service.ContractWriteService;

import lombok.extern.slf4j.Slf4j;

/**
 * 分布式事务-拟定合同
 * 
 * @author deyu
 */
@Slf4j
@Service
public class ContractWriteServiceImpl implements ContractWriteService {
	
	@Autowired
    private StringRedisTemplate redisTemplate;

	@Override
	@TccTransaction(confirmMethod = "cm", cancelMethod = "cl", executeClass = ContractWriteServiceImpl.class)
	public int writeContract(Object contract) {
		log.info("签合同，当前记录写入数据库，并标记中间态：未生效");
		return 1;
	}

	public void cm(Object contract) {
		redisTemplate.opsForValue().set("合同", "有效");
		log.info("签合同，当前记录写入数据库，并标记终态：有效");
	}

	public void cl(Object contract) {
		log.info("签合同，当前记录写入数据库，并标记终态：撤销");
	}

}
