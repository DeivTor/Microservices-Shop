package com.api.sexshop.repositories;

import com.api.sexshop.entities.ProvedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvedoresRepository extends JpaRepository<ProvedorEntity, UUID> {

}
