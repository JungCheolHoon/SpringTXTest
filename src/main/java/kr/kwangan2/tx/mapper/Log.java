package kr.kwangan2.tx.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Log {

	@Insert(" insert into moneyLog (num,giveer,getter,status,playtime) values (seq_moneyLog.nextval,'철수','영희',#{flag},#{money})")
	public int insertLogMoney(String flag, int money);
	
	
}
