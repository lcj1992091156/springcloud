package com.idp.saas.mapper;

import com.idp.saas.po.Company;
import com.idp.saas.po.CompanyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyMapper {
	long countByExample(CompanyExample example);

	int deleteByExample(CompanyExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Company record);

	int insertSelective(Company record);

	List<Company> selectByExample(CompanyExample example);

	Company selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

	int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

	int updateByPrimaryKeySelective(Company record);

	int updateByPrimaryKey(Company record);
}