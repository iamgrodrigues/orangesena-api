package com.iamgrodrigues.orangesenaapi.repository;

import com.iamgrodrigues.orangesenaapi.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
