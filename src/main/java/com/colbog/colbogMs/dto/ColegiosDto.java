package com.colbog.colbogMs.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColegiosDto {

    private String nombreEstablecimiento;
    private String zona;
    private String direccion;
    private String telefono;
    private String tipoEstablecimiento;
    private String niveles;
    private String jornadas;
    private String especialidad;
    private String modelosEducativos;
    private String capacidadesExcepcionales;
    private String discapacidades;
    private String idiomas;
    private String prestadorDeServicio;
    private String propiedadPlantaFisica;
    private String calendario;
    private String correoElectronico;
}
