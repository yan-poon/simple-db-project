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
@RequestMapping("/jdbc")
public class JdbcController {

	private final CoinJdbcService coinJdbcService;

	public JdbcController(CoinJdbcService coinJdbcService) {
		this.coinJdbcService = coinJdbcService;
	}

	@GetMapping("/coins")
	public List<Coin> getAllCoinsByJdbc() {
		return coinJdbcService.getAllCoins();
	}

	@PostMapping("/coins")
	public Coin addNewCoinByJdbc(@RequestBody Coin coin) {
		return coinJdbcService.addNewCoin(coin);
	}

	@GetMapping("/coins/{id}")
	public Coin getCoinByJdbc(@PathVariable("id") int id) {
		return coinJdbcService.getCoinById(id);
	}

}
