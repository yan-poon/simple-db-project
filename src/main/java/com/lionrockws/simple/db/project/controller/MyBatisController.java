package com.lionrockws.simple.db.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinMyBatisService;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {

	private final CoinMyBatisService coinMyBatisService;

	public MyBatisController(CoinMyBatisService coinMyBatisService) {
		this.coinMyBatisService = coinMyBatisService;
	}

	@GetMapping("/coins")
	public List<Coin> getCoins(@RequestParam(name = "code", required = false) String code) {
		return coinMyBatisService.getCoins(code);
	}

	@PostMapping("/coins")
	public Coin insertCoinByMybatis(@RequestBody Coin coin) {
		int affectedRow = coinMyBatisService.insertCoin(coin);
		return coin;
	}

}
