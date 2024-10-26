package com.api.sexshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvedorEntity {
    private UUID id;
    private String name;
    private String email;
    private int telefono;
    private String direccion;
}
