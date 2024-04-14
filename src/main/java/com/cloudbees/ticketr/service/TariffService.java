package com.cloudbees.ticketr.service;

import com.cloudbees.ticketr.model.Tariff;
import com.cloudbees.ticketr.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public List<Tariff> getAllTariffs() {
        return this.tariffRepository.findAll();
    }

    public Optional<Tariff> getTariffById(Long id) {
        return this.tariffRepository.findById(id);
    }
}
