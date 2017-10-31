package test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.web.controller.BankController;
import com.web.entity.Bank;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BankControllerTest {

	
	MockMvc mockmvc;
	
	@Resource
	BankController bankController;
	
	@Before
	public void setUp() throws Exception {
		mockmvc=MockMvcBuilders.standaloneSetup(bankController).build();
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		MvcResult andReturn=mockmvc.perform(MockMvcRequestBuilders.post("/findAll.do"))
		.andReturn();
		ModelAndView response = andReturn.getModelAndView();
		List<Bank> list= (List<Bank>) response.getModel().get("list");
		for (Bank bank : list) {
			System.out.println(bank.getBankName());
		}
	}
	
	
	@Test
	public void testDeleteById(){
		try {
			MvcResult andReturn=mockmvc.perform(MockMvcRequestBuilders.post("/deleteById.do")
					.param("bankId", "4"))
					.andReturn();
			System.out.println(andReturn.getModelAndView().getModel().get("res"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		try {
			MvcResult andReturn=mockmvc.perform(MockMvcRequestBuilders.post("/update.do")
					.param("bankId", "4").param("bankName", "bbb"))
					.andReturn();
			System.out.println(andReturn.getModelAndView().getModel().get("res"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testInsert(){
		try {
			MvcResult andReturn=mockmvc.perform(MockMvcRequestBuilders.post("/insert.do")
					.param("bankName", "aaa"))
					.andReturn();
			System.out.println(andReturn.getModelAndView().getModel().get("res"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
