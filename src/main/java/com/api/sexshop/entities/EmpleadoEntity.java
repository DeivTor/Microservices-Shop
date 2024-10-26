package com.api.sexshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    private UUID id;
    private String nombre;
    private String apellido;
    private int telefono;
    private String cargo;
}
