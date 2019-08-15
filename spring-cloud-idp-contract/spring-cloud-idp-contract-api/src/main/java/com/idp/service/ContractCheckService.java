package com.idp.service;

/**
 * 审核合同
 * @author deyu
 */
public interface ContractCheckService {
	
	/**
	 * 提交合同审核
	 * @param contractId
	 * @return 审核员姓名
	 */
	public String reviewContract(String contractId);
	
}
