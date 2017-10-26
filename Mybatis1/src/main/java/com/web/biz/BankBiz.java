package com.web.biz;

import java.util.List;

import com.web.entity.Bank;

/**
 * 银行表实体类的业务逻辑层
 * @author java201
 *
 */
public interface BankBiz {
	
	/**
	 * 添加
	 * @param bank
	 * @return
	 */
	public int insert(Bank bank);
	
	/**
	 * 根据主键删除
	 * @param bankId
	 * @return
	 */
	public int deleteById(int bankId);
	
	/**
	 * 修改
	 * @param bank
	 * @return
	 */
	public int updateById(Bank bank);

	
	/**
	 * 分页查询的总条目数
	 * @return
	 */
	public int selectCount();
	
	/**
	 * 根据主键查询
	 * @param bankId
	 * @return
	 */
	public Bank selectById(int bankId);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Bank> selectAll();
	
}
