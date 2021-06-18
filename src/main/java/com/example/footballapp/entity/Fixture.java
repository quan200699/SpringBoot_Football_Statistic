package com.example.footballapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class Fixture {
    @Id
    private Long id;

    @ManyToOne
    private League league;

    private String round;

    @OneToOne
    private Team homeTeam;

    @OneToOne
    private Team awayTeam;

    private String status;

    private Integer goalsHomeTeam;

    private Integer goalsAwayTeam;
}
