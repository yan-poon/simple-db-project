package com.lionrockws.simple.db.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lionrockws.simple.db.project.model.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

}
