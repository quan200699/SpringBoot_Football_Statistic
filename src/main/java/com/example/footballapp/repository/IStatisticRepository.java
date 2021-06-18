package com.example.footballapp.repository;

import com.example.footballapp.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatisticRepository extends JpaRepository<Statistic, Long> {
}
