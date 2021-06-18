package com.example.footballapp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatisticResponse {
    @JsonProperty("Shots On Goal")
    private Statistic shotOnGoal;

    @JsonProperty("Total Shots")
    private Statistic totalShot;

    @JsonProperty("Corner Kicks")
    private Statistic cornerKick;

    @JsonProperty("Goalkeeper Saves")
    private Statistic goalKeeperSave;

    @JsonProperty("Yellow Cards")
    private Statistic yellowCard;

    @JsonProperty("Fouls")
    private Statistic fouls;

    @JsonProperty("Offsides")
    private Statistic offsides;

    @Data
    private static class Statistic {
        @JsonProperty("home")
        private Integer home;

        @JsonProperty("home")
        private Integer away;
    }
}