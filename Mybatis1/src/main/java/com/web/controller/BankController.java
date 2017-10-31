package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.biz.BankBiz;
import com.web.entity.Bank;

@Controller
@RequestMapping(value="")
public class BankController {

	@Resource(name="bankBizImpl")
	BankBiz bankBiz;
	
	@RequestMapping(value="findAll")
	public ModelAndView findAll(ModelAndView mv){
		List<Bank> list=bankBiz.selectAll();
		mv.addObject("list", list);
		mv.setViewName("findAll");
		return mv;
	}
	
	@RequestMapping(value="deleteById")
	public ModelAndView deleteById(ModelAndView mv,int bankId){
		int res=bankBiz.deleteById(bankId);
		mv.addObject("res", res);
		mv.setViewName("");
		return mv;
	}
	
	@RequestMapping(value="update")
	public ModelAndView update(ModelAndView mv,String bankName,int bankId){
		int res=bankBiz.updateById(new Bank(bankId, bankName));
		mv.addObject("res", res);
		mv.setViewName("");
		return mv;
	}
	
	@RequestMapping(value="insert")
	public ModelAndView insert(ModelAndView mv,String bankName){
		int res=bankBiz.insert(new Bank(0, bankName));
		mv.addObject("res", res);
		mv.setViewName("");
		return mv;
	}
}
