package com.idp.saas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idp.saas.service.ContractService;

/**
 * 合同-Jd服务%分布式事务
 * 
 * @author deyu
 */
@RestController
public class ContractJdController {
	private final Logger log = LoggerFactory.getLogger(ContractJdController.class);

	@Autowired
	private ContractService contractServiceImpl;

	/**
	 * 电子合同-Jd定制%分布式事务
	 * 
	 * @return
	 */
	@RequestMapping("/jd/crmcontract")
	public String rsrCRMContract() {
		log.info("合同-Jd服务 rsrCRMContract() ");
		contractServiceImpl.signContractJd();
		return "JD定制";
	}

}
