package com.api.sexshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmpleadoEntity {
    @Id
    private UUID id;
    private String nombre;
    private String apellido;
    private int telefono;
    private String cargo;
}
