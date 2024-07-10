package com.lionrockws.simple.db.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.model.Coin;
import com.lionrockws.simple.db.project.repository.CoinRepository;

/**
 * The {@code CoinJpaService} class provides services for accessing and manipulating {@code Coin} data in a database using JPA.
 * It utilizes {@link CoinRepository} for database operations, offering methods to retrieve all coins, retrieve a coin by its ID, and add a new coin.
 */
@Service
public class CoinJpaService {

	private CoinRepository coinRepo;

	/**
     * Constructs a new {@code CoinJpaService} with the specified {@code CoinRepository}.
     * 
     * @param coinRepo the {@code CoinRepository} to be used for database operations.
     */
	public CoinJpaService(CoinRepository coinRepo) {
		this.coinRepo = coinRepo;
	}

	/**
     * Retrieves all coins from the database.
     * 
     * @return a list of {@code Coin} instances representing all coins in the database.
     */
	public List<Coin> getAllCoins() {
		return coinRepo.findAll();
	}

	/**
     * Retrieves a coin by its ID.
     * 
     * @param id the ID of the coin to retrieve.
     * @return an {@code Optional<Coin>} containing the coin if found, or an empty {@code Optional} if not.
     */
	public Optional<Coin> getCoinById(long id) {
		return coinRepo.findById(id);
	}

	/**
     * Adds a new coin to the database if it does not already exist.
     * 
     * @param coin the {@code Coin} entity to add.
     * @return the added {@code Coin} entity, or the existing one if it already exists.
     */
	public Coin addNewCoin(Coin coin) {
		Optional<Coin> existingCoin = coinRepo.findById(coin.getId());
		if (existingCoin.isEmpty()) { 
			return coinRepo.save(coin);
		} else {
			return existingCoin.get();
		}
	}

}
