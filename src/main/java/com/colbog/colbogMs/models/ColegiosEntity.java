package com.colbog.colbogMs.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "colegios")
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColegiosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "nombreestablecimiento")
    private String nombreEstablecimiento;
    @Column(name = "zona")
    private String zona;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "tipo_establecimiento")
    private String tipoEstablecimiento;
    @Column(name = "niveles")
    private String niveles;
    @Column(name = "jornadas")
    private String jornadas;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "modelos_educativos")
    private String modelosEducativos;
    @Column(name = "capacidades_excepcionales")
    private String capacidadesExcepcionales;
    @Column(name = "discapacidades")
    private String discapacidades;
    @Column(name = "idiomas")
    private String idiomas;
    @Column(name = "prestador_de_servicio")
    private String prestadorDeServicio;
    @Column(name = "propiedad_planta_fisica")
    private String propiedadPlantaFisica;
    @Column(name = "calendario")
    private String calendario;
    @Column(name = "correo_electronico")
    private String correoElectronico;


}
