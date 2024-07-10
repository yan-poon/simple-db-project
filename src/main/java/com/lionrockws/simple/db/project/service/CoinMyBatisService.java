package com.lionrockws.simple.db.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.mapper.CoinMapper;
import com.lionrockws.simple.db.project.model.Coin;

/**
 * The {@code CoinMyBatisService} class provides services for accessing and manipulating {@code Coin} data in a database using MyBatis.
 * It utilizes {@link CoinMapper} for database operations, offering methods to retrieve a coin by its ID, retrieve coins by code, and insert a new coin.
 */
@Service
public class CoinMyBatisService {

	private CoinMapper coinMapper;

	/**
     * Constructs a new {@code CoinMyBatisService} with the specified {@code CoinMapper}.
     * 
     * @param coinMapper the {@code CoinMapper} to be used for database operations.
     */
	public CoinMyBatisService(CoinMapper coinMapper) {
		this.coinMapper = coinMapper;
	}
	
	/**
     * Retrieves a coin by its ID.
     * 
     * @param id the ID of the coin to retrieve.
     * @return the {@code Coin} entity if found, or {@code null} if not found.
     */
	public Coin getCoinById(long id) {
		return coinMapper.selectCoinById(id);
	}
	
	/**
     * Retrieves coins filtered by code. If the code is {@code null} or empty, it retrieves all coins.
     * 
     * @param code the code to filter coins by.
     * @return a list of {@code Coin} entities.
     */
	public List<Coin> getCoins(String code) {
		return coinMapper.selectCoins(code);
	}
	
	/**
     * Inserts a new coin into the database.
     * 
     * @param coin the {@code Coin} entity to insert.
     * @return the number of rows affected.
     */
	public int insertCoin(Coin coin) {
		return coinMapper.insertCoin(coin);
	}

}
