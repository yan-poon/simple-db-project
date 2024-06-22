package com.lionrockws.simple.db.project.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String sqlStmt = "select id, name, code, description, chain from coin";
		RowMapper<Coin> coinRowMapper = new RowMapper<Coin>() {
			@Override
			public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Coin coin=new Coin();
				coin.setId(rs.getInt(1));
				coin.setName(rs.getString(2));
				coin.setCode(rs.getString(3));
				coin.setDescription(rs.getString(4));
				coin.setChain(rs.getString(5));
				return coin;
			}
		};
		List<Coin> coins = jdbcTemplate.query(sqlStmt, coinRowMapper);
		return coins;
	}
	
	public Coin getCoinById(int id) {
		String sqlStmt = "select id, name, code, description, chain from coin where id=?";
		RowMapper<Coin> coinRowMapper = new RowMapper<Coin>() {
			@Override
			public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Coin coin=new Coin();
				coin.setId(rs.getInt(1));
				coin.setName(rs.getString(2));
				coin.setCode(rs.getString(3));
				coin.setDescription(rs.getString(4));
				coin.setChain(rs.getString(5));
				return coin;
			}
		};
		List<Coin> coins = jdbcTemplate.query(sqlStmt, coinRowMapper, id);
		if(coins==null||coins.isEmpty()) {
			return null;
		}
		return coins.get(0);
	}
	
	

}
