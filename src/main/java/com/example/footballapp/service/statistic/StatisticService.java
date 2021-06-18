package com.example.footballapp.service.statistic;

import com.example.footballapp.entity.Statistic;
import com.example.footballapp.repository.IStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticService implements IStatisticService {
    @Autowired
    private IStatisticRepository statisticRepository;

    @Override
    public List<Statistic> findAll() {
        return statisticRepository.findAll();
    }

    @Override
    public List<Statistic> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Statistic> statistics = statisticRepository.findAll(pageRequest);
        return statistics.getContent();
    }

    @Override
    public Statistic save(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Override
    public Optional<Statistic> findById(Long id) {
        return statisticRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        statisticRepository.deleteById(id);
    }
}
