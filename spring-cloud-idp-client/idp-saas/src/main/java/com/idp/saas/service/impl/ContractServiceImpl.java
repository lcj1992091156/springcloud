package com.idp.saas.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.idp.saas.mapper.CompanyMapper;
import com.idp.saas.po.Company;
import com.idp.saas.service.ContractService;
import com.idp.service.ContractCheckService;
import com.idp.service.ContractWriteService;

import lombok.extern.slf4j.Slf4j;

/**
 * 合同服务实现%分布式事务
 * 
 * @author deyu
 */
@Slf4j
@Service
public class ContractServiceImpl implements ContractService {
	@Reference(version = "0.1", retries = -1, check = false, loadbalance = "txlcn_random")
	private ContractCheckService contractCheckServiceImpl;
	@Reference
	private ContractWriteService contractWriteServiceImpl;
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	@LcnTransaction
	public String signContractRsr() {
		// 获取企业信息
		Company company = companyMapper.selectByPrimaryKey(1);
		log.info(company == null ? "企业信息_" : company.getName());
		// 修改企业信息
		Company updateCompany = new Company() {
			{
				setId(1);
				setName("NBxuanji");
			}
		};
		companyMapper.updateByPrimaryKey(updateCompany);
		// 起草合同RPC
		contractWriteServiceImpl.writeContract(new Integer(1));
		// 审核草稿->审核员RPC
		String assessorName = contractCheckServiceImpl.reviewContract("101010010101010");
		// 此处抛出异常（重复起草）
		int writeContractState = contractWriteServiceImpl.writeContract(new Integer(2));
//		if (0 == 0) {
//			throw new RuntimeException("业务路径上的事务能否会滚？");
//		}
		return StringUtils.isBlank(assessorName) ? "合同审核中，审核员_" : ("合同审核中，审核员:" + assessorName);
	}

	@Override
	@TccTransaction
	public void signContractJd() {
		// 修改企业信息
		Company updateCompany = new Company() {
			{
				setId(1);
				setName("NBJd");
			}
		};
		companyMapper.updateByPrimaryKey(updateCompany);
		contractWriteServiceImpl.writeContract(new Integer(2));
//		if (1 == 1) {
//			throw new RuntimeException("");
//		}
	}

}
