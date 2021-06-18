package com.example.footballapp.repository;

import com.example.footballapp.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILeagueRepository extends JpaRepository<League, Long> {
}
