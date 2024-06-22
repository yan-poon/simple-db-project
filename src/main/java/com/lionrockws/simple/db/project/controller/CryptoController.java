package com.lionrockws.simple.db.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinJdbcService;
import com.lionrockws.simple.db.project.service.CoinJpaService;

@RestController
@RequestMapping("/crypto/coin")
public class CryptoController {
	
	private final CoinJdbcService coinJdbcService;
	private final CoinJpaService coinJpaService;
	
	public CryptoController(CoinJdbcService coinJdbcService, CoinJpaService coinJpaService) {
		super();
		this.coinJdbcService = coinJdbcService;
		this.coinJpaService = coinJpaService;
	}

	@GetMapping("/jdbc")
	public List<Coin> getAllCoinsByJdbc() {
		return coinJdbcService.getAllCoins();
	}
	
	@GetMapping("/jdbc/{id}")
	public Coin getCoinByJdbc(@PathVariable("id") int id) {
		return coinJdbcService.getCoinById(id);
	}

}
