package com.cloudbees.ticketr.controller;

import com.cloudbees.ticketr.model.Tariff;
import com.cloudbees.ticketr.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tariffs")
public class TariffController {

    private final TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping()
    public List<Tariff> getTariffs() {
        return tariffService.getAllTariffs();
    }
}
