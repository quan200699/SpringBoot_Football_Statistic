package com.example.footballapp.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class League {
    @Id
    private Long id;

    private String name;

    private String logo;
}
