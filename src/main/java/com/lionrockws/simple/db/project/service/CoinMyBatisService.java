package com.lionrockws.simple.db.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.mapper.CoinMapper;
import com.lionrockws.simple.db.project.model.Coin;

@Service
public class CoinMyBatisService {

	private CoinMapper coinMapper;

	public CoinMyBatisService(CoinMapper coinMapper) {
		this.coinMapper = coinMapper;
	}
	
	public Coin getCoinById(long id) {
		return coinMapper.selectCoinById(id);
	}
	
	public List<Coin> getCoins(String code) {
		return coinMapper.selectCoins(code);
	}
	
	public int insertCoin(Coin coin) {
		return coinMapper.insertCoin(coin);
	}

}
