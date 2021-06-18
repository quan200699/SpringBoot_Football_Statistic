package com.example.footballapp.service.team;

import com.example.footballapp.entity.Team;
import com.example.footballapp.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Team> teams = teamRepository.findAll(pageRequest);
        return teams.getContent();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        teamRepository.deleteById(id);
    }
}
