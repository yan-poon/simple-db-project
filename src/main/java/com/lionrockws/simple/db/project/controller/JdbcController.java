package com.lionrockws.simple.db.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinJdbcService;

/**
 * The {@code JdbcController} class is a Spring REST controller that handles HTTP requests related to {@code Coin} entities using JDBC.
 * It provides endpoints for retrieving all coins, adding a new coin, and retrieving a single coin by its ID.
 * This controller uses {@link CoinJdbcService} to interact with the database through JDBC.
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

	private final CoinJdbcService coinJdbcService;

	/**
     * Constructs a new {@code JdbcController} with the specified {@code CoinJdbcService}.
     * 
     * @param coinJdbcService the service used for accessing {@code Coin} data through JDBC.
     */
	public JdbcController(CoinJdbcService coinJdbcService) {
		this.coinJdbcService = coinJdbcService;
	}

	/**
     * Handles the HTTP GET request to retrieve all coins.
     * 
     * @return a list of {@code Coin} entities.
     */
	@GetMapping("/coins")
	public List<Coin> getAllCoinsByJdbc() {
		return coinJdbcService.getAllCoins();
	}

	/**
     * Handles the HTTP POST request to add a new coin.
     * 
     * @param coin the {@code Coin} entity to add.
     * @return the added {@code Coin} entity.
     */
	@PostMapping("/coins")
	public Coin addNewCoinByJdbc(@RequestBody Coin coin) {
		return coinJdbcService.addNewCoin(coin);
	}

	/**
     * Handles the HTTP GET request to retrieve a single coin by its ID.
     * 
     * @param id the ID of the coin to retrieve.
     * @return the {@code Coin} entity if found, or {@code null} if not found.
     */
	@GetMapping("/coins/{id}")
	public Coin getCoinByJdbc(@PathVariable("id") int id) {
		return coinJdbcService.getCoinById(id);
	}

}
