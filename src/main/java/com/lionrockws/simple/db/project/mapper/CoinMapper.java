package com.lionrockws.simple.db.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lionrockws.simple.db.project.model.Coin;

@Mapper
public interface CoinMapper {

	Coin selectCoinByCode(@Param("code") String code);

	int insertCoin(@Param("coin") Coin coin);

}
