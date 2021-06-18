package com.example.footballapp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FixtureResponse {
    @JsonProperty("fixture_id")
    private Long id;

    @JsonProperty("league_id")
    private Long leagueId;

    @JsonProperty("homeTeam_id")
    private Long homeTeamId;

    @JsonProperty("awayTeam_id")
    private Long awayTeamId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("statusShort")
    private String statusShort;
}
