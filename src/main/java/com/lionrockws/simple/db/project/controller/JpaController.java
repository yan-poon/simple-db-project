package com.lionrockws.simple.db.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.service.CoinJpaService;

/**
 * The {@code JpaController} class is a Spring REST controller that handles HTTP requests related to {@code Coin} entities.
 * It provides endpoints for retrieving all coins, retrieving a single coin by its ID, and adding a new coin.
 * This controller uses {@link CoinJpaService} to interact with the database.
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {

	private final CoinJpaService coinJpaService;

	/**
     * Constructs a new {@code JpaController} with the specified {@code CoinJpaService}.
     * 
     * @param coinJpaService the service used for accessing {@code Coin} data.
     */
	public JpaController(CoinJpaService coinJpaService) {
		this.coinJpaService = coinJpaService;
	}

	/**
     * Handles the HTTP GET request to retrieve all coins.
     * 
     * @return a list of {@code Coin} entities.
     */
	@GetMapping("/coins")
	public List<Coin> getAllCoinsByJpa() {
		return coinJpaService.getAllCoins();
	}

	/**
     * Handles the HTTP GET request to retrieve a single coin by its ID.
     * 
     * @param id the ID of the coin to retrieve.
     * @return an {@code Optional<Coin>} containing the coin if found, or an empty {@code Optional} if not.
     */
	@GetMapping("/coins/{id}")
	public Optional<Coin> getCoinByJpa(@PathVariable("id") int id) {
		return coinJpaService.getCoinById(id);
	}

	/**
     * Handles the HTTP POST request to add a new coin.
     * 
     * @param coin the {@code Coin} entity to add.
     * @return the added {@code Coin} entity.
     */
	@PostMapping("/coins")
	public Coin addNewCoinByJpa(@RequestBody Coin coin) {
		return coinJpaService.addNewCoin(coin);
	}

}
