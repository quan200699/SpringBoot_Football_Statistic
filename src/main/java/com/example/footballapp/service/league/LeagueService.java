package com.example.footballapp.service.league;

import com.example.footballapp.entity.League;
import com.example.footballapp.repository.ILeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService implements ILeagueService {
    @Autowired
    private ILeagueRepository leagueRepository;

    @Override
    public List<League> findAll() {
        return leagueRepository.findAll();
    }

    @Override
    public List<League> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<League> leagues = leagueRepository.findAll(pageRequest);
        return leagues.getContent();
    }

    @Override
    public League save(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public Optional<League> findById(Long id) {
        return leagueRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        leagueRepository.deleteById(id);
    }
}
