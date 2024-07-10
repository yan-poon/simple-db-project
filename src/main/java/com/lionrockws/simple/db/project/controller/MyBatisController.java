package com.lionrockws.simple.db.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinMyBatisService;

/**
 * The {@code MyBatisController} class is a Spring REST controller that handles HTTP requests related to {@code Coin} entities using MyBatis.
 * It provides endpoints for retrieving a single coin by its ID, retrieving all coins or coins filtered by code, and adding a new coin.
 * This controller uses {@link CoinMyBatisService} to interact with the database through MyBatis.
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisController {

	private final CoinMyBatisService coinMyBatisService;

	/**
     * Constructs a new {@code MyBatisController} with the specified {@code CoinMyBatisService}.
     * 
     * @param coinMyBatisService the service used for accessing {@code Coin} data through MyBatis.
     */
	public MyBatisController(CoinMyBatisService coinMyBatisService) {
		this.coinMyBatisService = coinMyBatisService;
	}

	/**
     * Handles the HTTP GET request to retrieve a single coin by its ID.
     * 
     * @param id the ID of the coin to retrieve.
     * @return the {@code Coin} entity if found, or {@code null} if not found.
     */
	@GetMapping("/coins/{id}")
	public Coin getCoinById(@PathVariable("id") long id) {
		return coinMyBatisService.getCoinById(id);
	}
	
	/**
     * Handles the HTTP GET request to retrieve all coins or coins filtered by code if the code parameter is provided.
     * 
     * @param code the code to filter coins by, can be {@code null} to retrieve all coins.
     * @return a list of {@code Coin} entities.
     */
	@GetMapping("/coins")
	public List<Coin> getCoins(@RequestParam(name = "code", required = false) String code) {
		return coinMyBatisService.getCoins(code);
	}

	/**
     * Handles the HTTP POST request to add a new coin.
     * 
     * @param coin the {@code Coin} entity to add.
     * @return the added {@code Coin} entity.
     */
	@PostMapping("/coins")
	public Coin insertCoinByMybatis(@RequestBody Coin coin) {
		coinMyBatisService.insertCoin(coin);
		return coin;
	}

}
