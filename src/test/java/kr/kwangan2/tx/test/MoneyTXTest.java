package kr.kwangan2.tx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.tx.mapper.BankingThread;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MoneyTXTest {

	
	@Setter(onMethod_ = @Autowired)
	private BankingThread bankingThread;
	
	@Test
	public void testLong() {
		bankingThread.start();
	}
	
}
