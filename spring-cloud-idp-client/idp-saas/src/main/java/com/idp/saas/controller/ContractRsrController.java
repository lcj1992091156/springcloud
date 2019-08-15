package com.idp.saas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idp.saas.service.ContractService;

/**
 * 合同-人事人服务%分布式事务
 * 
 * @author deyu
 */
@RestController
public class ContractRsrController {
	private final Logger log = LoggerFactory.getLogger(ContractRsrController.class);

	@Autowired
	private ContractService contractServiceImpl;

	/**
	 * 电子合同-人事人定制%分布式事务
	 * 
	 * @return
	 */
	@RequestMapping("/rsr/crmcontract")
	public String rsrCRMContract() {
		log.info("合同-人事人服务 rsrCRMContract() ");
		String assessorName = contractServiceImpl.signContractRsr();
		return assessorName;
	}

}
