package com.lionrockws.simple.db.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.repository.CoinRepository;

@Service
public class CoinJpaService {

	private CoinRepository coinRepo;

	public CoinJpaService(CoinRepository coinRepo) {
		this.coinRepo = coinRepo;
	}

	public List<Coin> getAllCoins() {
		return coinRepo.findAll();
	}

	public Optional<Coin> getCoinById(long id) {
		return coinRepo.findById(id);
	}

	public Coin addNewCoin(Coin coin) {
		Optional<Coin> existingCoin = coinRepo.findById(coin.getId());
		if (existingCoin.isEmpty()) { 
			return coinRepo.save(coin);
		} else {
			return existingCoin.get();
		}
	}

}
