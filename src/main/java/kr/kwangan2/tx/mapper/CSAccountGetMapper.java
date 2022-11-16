package kr.kwangan2.tx.mapper;

import org.apache.ibatis.annotations.Select;

public interface CSAccountGetMapper {

	@Select(" select money from cs ")
	public int selectCSMoney();
	
}
