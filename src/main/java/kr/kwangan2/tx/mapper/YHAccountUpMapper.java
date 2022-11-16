package kr.kwangan2.tx.mapper;

import org.apache.ibatis.annotations.Update;

public interface YHAccountUpMapper {
	
	@Update(" UPDATE YH SET money = money + #{data} ")
	public int updateYHMoney(int data);
	
}
