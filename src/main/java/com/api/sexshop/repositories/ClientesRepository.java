package com.api.sexshop.repositories;

import com.api.sexshop.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity, UUID> {

}
