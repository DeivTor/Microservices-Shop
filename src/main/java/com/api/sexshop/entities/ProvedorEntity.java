package com.api.sexshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProvedorEntity {
    @Id
    private UUID id;
    private String name;
    private String email;
    private int telefono;
    private String direccion;
}
