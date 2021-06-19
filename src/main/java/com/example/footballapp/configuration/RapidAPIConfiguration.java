package com.example.footballapp.configuration;

import com.example.footballapp.dto.response.LeagueResponse;
import com.example.footballapp.entity.League;
import com.example.footballapp.service.api.APIService;
import com.example.footballapp.service.fixture.IFixtureService;
import com.example.footballapp.service.league.ILeagueService;
import com.example.footballapp.service.statistic.IStatisticService;
import com.example.footballapp.service.team.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class RapidAPIConfiguration {
    @Autowired
    private IFixtureService fixtureService;

    @Autowired
    private ILeagueService leagueService;

    @Autowired
    private IStatisticService statisticService;

    @Autowired
    private ITeamService teamService;

    @Autowired
    private APIService apiService;

    @PostConstruct
    public void initLeague() {
        List<League> leagues = leagueService.findAll();
        if (leagues.isEmpty()) {
            LeagueResponse leagueResponse = apiService.getLeagueFromRapid(StaticVariable.PREMIER_LEAGUE, StaticVariable.ENGLAND);
            League league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.PRIMERA_DIVISION, StaticVariable.SPAIN);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.BUNDESLIGA, StaticVariable.GERMANY);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.LIGUE_1, StaticVariable.FRANCE);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.PRIMEIRA_LIGA, StaticVariable.PORTUGAL);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.SERIE_A, StaticVariable.ITALY);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.PREMIER_LEAGUE, StaticVariable.RUSSIA);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
            leagueResponse = apiService.getLeagueFromRapid(StaticVariable.SUPER_LIG, StaticVariable.TURKEY);
            league = convertLeagueResponseToEntity(leagueResponse);
            leagueService.save(league);
        }
    }

    public League convertLeagueResponseToEntity(LeagueResponse leagueResponse) {
        return new League(leagueResponse.getId(), leagueResponse.getName(), leagueResponse.getLogo());
    }
}
