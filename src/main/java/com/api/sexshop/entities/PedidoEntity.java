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
public class PedidoEntity {

    @Id
    private UUID id;
    private UUID id_cliente;
    private UUID id_producto;
    private int cantidad;
    private Double total;
}
