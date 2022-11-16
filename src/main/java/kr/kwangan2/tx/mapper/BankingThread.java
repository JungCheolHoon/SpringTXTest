package kr.kwangan2.tx.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import kr.kwangan2.tx.service.MoneyTXService;
import lombok.Setter;

// Thread : Runnable 인터페이스를 구현하거나, Runnable 인터페이스를 구현한 Thread를 상속
// run() : Thread가 수행할 로직 (일반적으로 while(true)를 사용하고 조건에 따라 빠져나가도록 설계)
public class BankingThread extends Thread {

	@Setter(onMethod_ = @Autowired)
	private MoneyTXService service;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);	// 1000밀리세컨드 동안 해당 스레드가 작업을 중지
				// sleep을 해야하는데 다른 쓰레드가 sleep을 방해하면 발생
			} catch (InterruptedException ie) {		
			}
			// 0~9000까지 1000단위로 임의 숫자 생성
			int money = (int)(Math.random()*10+1)*1000;
			service.updateMoney(money);
		}
	}

}