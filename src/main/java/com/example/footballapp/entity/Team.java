package com.example.footballapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Team {
    @Id
    private Long id;

    private String name;

    private String code;

    private String logo;
}
