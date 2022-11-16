package kr.kwangan2.tx.mapper;

import org.apache.ibatis.annotations.Update;

public interface CSAccountUpMapper {

	@Update(" UPDATE CS SET money = #{data} WHERE money > #{data}")
	public int updateCSMoney(int data);
	
}
