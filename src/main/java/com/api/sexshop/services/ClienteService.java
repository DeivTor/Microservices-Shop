package com.api.sexshop.services;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

import com.api.sexshop.entities.ClienteEntity;
import com.api.sexshop.repositories.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClientesRepository clientesRepository;

    public ClienteService() {

    }

    //(GET){READ - ALL}
    public List<ClienteEntity> getClientes() {
        List<ClienteEntity> clientes = clientesRepository.findAll();
        return clientes;
    }

    //(GET){READ - ID}
    public Optional<ClienteEntity> getClienteById(UUID id) {
        Optional<ClienteEntity> clienteFound = clientesRepository.findById(id);
        if(clienteFound.isPresent()) {
            return clienteFound;
        }else{
            return Optional.empty();
        }
    }

    //(POST){CREATE}
    public String createCliente(ClienteEntity cliente) {
        cliente.setId(UUID.randomUUID());
        if (clientesRepository.existsById(cliente.getId())) {
            return "Cliente ya existe";
        }else {
            clientesRepository.save(cliente);
            return "Cliente creado con exito";
        }
    }

    //(PUT){UPDATE}
    public String updateClienteById(UUID id, ClienteEntity cliente) {
        //Optional<ClienteEntity> clienteFound = clientesRepository.findById(id);
        Optional<ClienteEntity> clienteFound = getClienteById(id);
        if(clienteFound.isPresent()) {
            clientesRepository.save(cliente);
            return "Cliente actualizado con exito";
        }else {
            return "Cliente no encontrado";
        }
    }

    //(DELETE){DELETE}
    public String deleteCLienteById(UUID id) {
        Optional<ClienteEntity> clienteFound = getClienteById(id);
        if(clienteFound.isPresent()) {
            clientesRepository.delete(clienteFound.get());
            return "Cliente eliminado con exito";
        }else{
            return "Cliente no encontrado";
        }
    }
}
