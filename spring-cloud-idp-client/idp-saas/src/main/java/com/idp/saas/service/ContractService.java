package com.idp.saas.service;

/**
 * 小前台-合同服务%分布式事务demo
 * 
 * @author deyu
 */
public interface ContractService {
	/**
	 * 人事人起草 合同，起草->审批->生成正式合同
	 * 
	 * @return 审批员姓名
	 */
	public String signContractRsr();

	/**
	 * 京东起草合同
	 * 
	 * @return
	 */
	public void signContractJd();
}
