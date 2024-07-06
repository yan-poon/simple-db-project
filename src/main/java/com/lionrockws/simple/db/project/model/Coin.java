package com.lionrockws.simple.db.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name="coinmarketcap_id")
	long coinMarketCapId;
	String name;
	String code;
	String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCoinMarketCapId() {
		return coinMarketCapId;
	}

	public void setCoinMarketCapId(long coinMarketCapId) {
		this.coinMarketCapId = coinMarketCapId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
