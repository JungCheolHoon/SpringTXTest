package kr.kwangan2.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kwangan2.tx.mapper.CSAccountGetMapper;
import kr.kwangan2.tx.mapper.CSAccountUpMapper;
import kr.kwangan2.tx.mapper.Log;
import kr.kwangan2.tx.mapper.YHAccountUpMapper;
import kr.kwangan2.tx.service.MoneyTXService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.SetDelegate;

@Service
@Log4j
public class MoneyTXServiceImpl implements MoneyTXService{

	@Setter(onMethod_ = @Autowired)
	private CSAccountUpMapper csAccountUpmapper;
	
	@Setter(onMethod_ = @Autowired)
	private YHAccountUpMapper yhAccountUpmapper;
	
	@Setter(onMethod_ = @Autowired)
	private CSAccountGetMapper csAccountGetMapper;
	
	@Setter(onMethod_ = @Autowired)
	private Log logMoney;
	
	@Transactional
	@Override
	public void updateMoney(int money) {
		int csMoney = csAccountGetMapper.selectCSMoney();
		if(csMoney>=money) {
			confirm("성공", money);
		}else {
			confirm("실패", money);
		}
		csAccountUpmapper.updateCSMoney(money);		
		yhAccountUpmapper.updateYHMoney(money);
	}

	@Override
	public void confirm(String flag, int money) {
		logMoney.insertLogMoney(flag, money);
	}

}
