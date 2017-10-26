package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.BankBiz;
import com.web.dao.BankDao;
import com.web.entity.Bank;

/**
 * 银行表实体类的业务逻辑层
 * @author java2bankdao.1
 *
 */
@Service
public class BankBizImpl implements BankBiz {
	@Resource
	BankDao bankdao;

	@Override
	public int insert(Bank bank) {
		return bankdao.insert(bank);
	}

	@Override
	public int deleteById(int bankId) {
		return bankdao.deleteById(bankId);
	}

	@Override
	public int updateById(Bank bank) {
		return bankdao.updateById(bank);
	}


	@Override
	public int selectCount() {
		return bankdao.selectCount();
	}

	@Override
	public Bank selectById(int bankId) {
		return bankdao.selectById(bankId);
	}

	@Override
	public List<Bank> selectAll() {
		return bankdao.selectAll();
	}
	
	
}
