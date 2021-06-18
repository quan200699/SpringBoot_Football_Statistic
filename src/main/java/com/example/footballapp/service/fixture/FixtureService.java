package com.example.footballapp.service.fixture;

import com.example.footballapp.entity.Fixture;
import com.example.footballapp.repository.IFixtureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureService implements IFixtureService {
    @Autowired
    private IFixtureRepository fixtureRepository;

    @Override
    public List<Fixture> findAll() {
        return fixtureRepository.findAll();
    }

    @Override
    public List<Fixture> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Fixture> fixtures = fixtureRepository.findAll(pageRequest);
        return fixtures.getContent();
    }

    @Override
    public Fixture save(Fixture fixture) {
        return fixtureRepository.save(fixture);
    }

    @Override
    public Optional<Fixture> findById(Long id) {
        return fixtureRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        fixtureRepository.deleteById(id);
    }
}
