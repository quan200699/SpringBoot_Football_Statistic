package com.example.footballapp.repository;

import com.example.footballapp.entity.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFixtureRepository extends JpaRepository<Fixture, Long> {
}
