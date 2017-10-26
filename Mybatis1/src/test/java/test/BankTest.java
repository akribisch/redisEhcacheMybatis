package test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.biz.BankBiz;
import com.web.entity.Bank;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BankTest {

	@Resource(name="bankBizImpl")
	BankBiz bankBiz;
	
	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	@Test
	public void testInsert() {
		assertEquals(1, bankBiz.insert(new Bank(0, "九龙坡")));
	}

	@Ignore
	@Test
	public void testDeleteById() {
		assertEquals(1, bankBiz.deleteById(1));
	}
	
	@Test
	public void testFindById(){
		assertEquals(2, bankBiz.selectById(2).getBankId());
	}

}
