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
public class ProductoEntity {
    @Id
    private UUID id;
    private String nombre;
    private String Categoria;
    private double precio;
    private int stock;
}
