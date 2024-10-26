package com.api.sexshop.controllers;

import com.api.sexshop.entities.ProvedorEntity;
import com.api.sexshop.services.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sexshop/provedores")
public class ProvedorController {

    public final ProvedorService provedorService;

    @Autowired
    public ProvedorController(ProvedorService provedorService) {
        this.provedorService = provedorService;
    }

    @GetMapping
    public List<ProvedorEntity> getAllProvedores() {
        return provedorService.getProvedores();
    }

    @GetMapping("/{id}")
    public Optional<ProvedorEntity> getProvedor(@PathVariable UUID id) {
        return provedorService.getProvedoresById(id);
    }

    @PostMapping
    public String createProvedor(@RequestBody ProvedorEntity provedor) {
        return provedorService.createProvedor(provedor);
    }

    @PutMapping("/{id}")
    public String updateProvedor(@PathVariable UUID id, @RequestBody ProvedorEntity provedor) {
        return provedorService.updateprovedorById(id, provedor);
    }

    @DeleteMapping("/{id}")
    public String deleteProvedor(@PathVariable UUID id) {
        return provedorService.deleteProvedorById(id);
    }
}
