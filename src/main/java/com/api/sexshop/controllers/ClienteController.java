package com.api.sexshop.controllers;

import com.api.sexshop.entities.ClienteEntity;
import com.api.sexshop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sexshop/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteEntity> getAllClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Optional<ClienteEntity> getCliente(@PathVariable UUID id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public String createCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable UUID id, @RequestBody ClienteEntity cliente) {
        return clienteService.updateClienteById(id, cliente);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable UUID id) {
        return clienteService.deleteCLienteById(id);
    }
}
