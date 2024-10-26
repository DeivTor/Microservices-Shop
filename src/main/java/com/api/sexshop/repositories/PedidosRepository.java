package com.api.sexshop.repositories;

import com.api.sexshop.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidosRepository extends JpaRepository<PedidoEntity, UUID> {

}
