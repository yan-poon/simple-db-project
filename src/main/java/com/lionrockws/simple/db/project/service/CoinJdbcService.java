package com.lionrockws.simple.db.project.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.lionrockws.simple.db.project.model.Coin;

@Service
public class CoinJdbcService {

	private final JdbcTemplate jdbcTemplate;

	public CoinJdbcService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Coin> getAllCoins() {
		String sqlStmt = "select id, coinmarketcap_id, name, code, description from coin";
		RowMapper<Coin> coinRowMapper = new RowMapper<Coin>() {
			@Override
			public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Coin coin = new Coin();
				coin.setId(rs.getLong(1));
				coin.setCoinMarketCapId(rs.getLong(2));
				coin.setName(rs.getString(3));
				coin.setCode(rs.getString(4));
				coin.setDescription(rs.getString(5));
				return coin;
			}
		};
		List<Coin> coins = jdbcTemplate.query(sqlStmt, coinRowMapper);
		return coins;
	}

	public Coin getCoinById(long id) {
		String sqlStmt = "select id, coinmarketcap_id, name, code, description from coin where id=?";
		RowMapper<Coin> coinRowMapper = new RowMapper<Coin>() {
			@Override
			public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Coin coin = new Coin();
				coin.setId(rs.getLong(1));
				coin.setCoinMarketCapId(rs.getLong(2));
				coin.setName(rs.getString(3));
				coin.setCode(rs.getString(4));
				coin.setDescription(rs.getString(5));
				return coin;
			}
		};
		List<Coin> coins = jdbcTemplate.query(sqlStmt, coinRowMapper, id);
		if (coins == null || coins.isEmpty()) {
			return null;
		}
		return coins.get(0);
	}

	public Coin addNewCoin(Coin coin) {
		System.out.println(coin);
		Coin existingCoin = getCoinById(coin.getId());
		System.out.println(existingCoin);
		if (existingCoin == null) {
			String sqlStmt = "insert into coin(coinmarketcap_id, name, code, description) values(?,?,?,?)";
			jdbcTemplate.update(sqlStmt, coin.getCoinMarketCapId(), coin.getName(), coin.getCode(), coin.getDescription());
			return coin;
		} else {
			return existingCoin;
		}
	}

}
