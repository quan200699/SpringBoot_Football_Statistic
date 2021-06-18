package com.example.footballapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Statistic {
    @Id
    private Long id;

    private String shotOnGoal;

    private String totalShot;

    private String cornerKick;

    private String goalKeeperSave;

    private String yellowCard;

    private String foul;

    private String offside;
}
