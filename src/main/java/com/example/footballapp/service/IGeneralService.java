package com.example.footballapp.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    List<T> findAll(int page, int size);

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}
