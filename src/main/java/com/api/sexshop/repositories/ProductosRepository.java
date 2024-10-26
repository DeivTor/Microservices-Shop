package com.api.sexshop.repositories;

import com.api.sexshop.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductosRepository extends JpaRepository<ProductoEntity, UUID> {

}
