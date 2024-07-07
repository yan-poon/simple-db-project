package com.lionrockws.simple.db.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.mapper.CoinMapper;
import com.lionrockws.simple.db.project.model.Coin;

@Service
public class CoinMyBatisService {

	private CoinMapper coinMapper;

	public CoinMyBatisService(CoinMapper coinMapper) {
		this.coinMapper = coinMapper;
	}
	
	public Coin getCoinByCode(String code) {
		return coinMapper.selectCoinByCode(code);
	}

}
