package com.lionrockws.simple.db.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.model.Coin;

@Service
public class CoinJpaService {

	public List<Coin> getAllCoins() {
		return new ArrayList<Coin>();
	}
	
	

}
