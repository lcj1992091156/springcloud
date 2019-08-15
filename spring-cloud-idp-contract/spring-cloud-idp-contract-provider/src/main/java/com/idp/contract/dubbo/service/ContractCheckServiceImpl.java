package com.idp.contract.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.idp.contract.mapper.UserMapper;
import com.idp.contract.po.User;
import com.idp.service.ContractCheckService;

import lombok.extern.slf4j.Slf4j;

/**
 * 分布式事务-审合同
 * 
 * @author deyu
 */
@Slf4j
@Service(version = "0.1")
public class ContractCheckServiceImpl implements ContractCheckService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@TxTransaction(type = "lcn")
	public String reviewContract(String contractId) {
		log.info("审核合同-提交lcnTC id : " + contractId);
		// 查询审核员信息
		User user = userMapper.selectByPrimaryKey(1);
		log.info("当前审核员 : " + user.getName());
		// 修改审核员的名字
		User updateUser = new User() {
			{
				setId(1);
				setName("少露露");
			}
		};
		userMapper.updateByPrimaryKey(updateUser);
		if (1 == 1) {
			throw new RuntimeException();
		}
		return user.getName();
	}

}
