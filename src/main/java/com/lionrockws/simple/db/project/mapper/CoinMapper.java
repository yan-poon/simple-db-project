package com.lionrockws.simple.db.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lionrockws.simple.db.project.model.Coin;

@Mapper
public interface CoinMapper {
	
	List<Coin> selectCoins(@Param("code") String code);

	int insertCoin(@Param("coin") Coin coin);

}
