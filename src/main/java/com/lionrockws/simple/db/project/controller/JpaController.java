package com.lionrockws.simple.db.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinJdbcService;
import com.lionrockws.simple.db.project.service.CoinJpaService;
import com.lionrockws.simple.db.project.service.CoinMyBatisService;

@RestController
@RequestMapping("/jpa")
public class JpaController {

	private final CoinJpaService coinJpaService;

	public JpaController(CoinJpaService coinJpaService) {
		this.coinJpaService = coinJpaService;
	}

	@GetMapping("/coins")
	public List<Coin> getAllCoinsByJpa() {
		return coinJpaService.getAllCoins();
	}

	@GetMapping("/coins/{id}")
	public Optional<Coin> getCoinByJpa(@PathVariable("id") int id) {
		return coinJpaService.getCoinById(id);
	}

	@PostMapping("/coins")
	public Coin addNewCoinByJpa(@RequestBody Coin coin) {
		return coinJpaService.addNewCoin(coin);
	}

}
