package com.lionrockws.simple.db.project.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.repository.CoinRepository;

@Service
public class CoinJpaService {
	
	private CoinRepository coinRepo;
	
	public CoinJpaService(CoinRepository coinRepo) {
		this.coinRepo=coinRepo;
	}

	public List<Coin> getAllCoins() {
		return coinRepo.findAll();
	}
	
	public Optional<Coin> getCoinById(int id) {
		return coinRepo.findById(id);
	}
	
	

}
