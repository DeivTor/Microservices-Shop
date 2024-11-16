package com.api.sexshop.services;

import com.api.sexshop.entities.ProvedorEntity;
import com.api.sexshop.repositories.ProvedoresRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProvedorService {

    private ProvedoresRepository provedoresRepository;

    public ProvedorService() {
    }


    //(GET){READ - ALL}
    public List<ProvedorEntity> getProvedores() {
        List<ProvedorEntity> provedores = provedoresRepository.findAll();
        return provedores;
    }

    //(GET){READ - ID}
    public Optional<ProvedorEntity> getProvedoresById(UUID id) {
        Optional<ProvedorEntity> provedorFound = provedoresRepository.findById(id);
        if(provedorFound.isPresent()) {
            return provedorFound;
        }else{
            return Optional.empty();
        }
    }

    //(POST){CREATE}
    public String createProvedor(ProvedorEntity provedor) {
        provedor.setId(UUID.randomUUID());
        if (provedoresRepository.existsById(provedor.getId())) {
            return "Ese provedor ya existe";
        }else {
            provedoresRepository.save(provedor);
            return "Provedor creado con exito";
        }
    }

    //(PUT){UPDATE}
    public String updateprovedorById (UUID id, ProvedorEntity provedor) {
        Optional<ProvedorEntity> provedorFound = getProvedoresById(id);
        if(provedorFound.isPresent()) {
            provedoresRepository.save(provedor);
            return "Provedor actualizado con exito";
        }else {
            return "Provedor no encontrado";
        }
    }

    //(DELETE){DELETE}
    public String deleteProvedorById(UUID id) {
        Optional<ProvedorEntity> productoFound = getProvedoresById(id);
        if(productoFound.isPresent()) {
            provedoresRepository.delete(productoFound.get());
            return "Provedor eliminado con exito";
        }else{
            return "Provedor no encontrado";
        }
    }

}
