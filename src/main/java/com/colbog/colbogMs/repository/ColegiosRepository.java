package com.colbog.colbogMs.repository;

import com.colbog.colbogMs.models.ColegiosEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ColegiosRepository extends JpaRepository<ColegiosEntity, Long> {

    @Query(value = "SELECT * FROM colegios e WHERE levenshtein(e.nombreestablecimiento, :nombre) <= :threshold", nativeQuery = true)
    List<ColegiosEntity> findByNombreEstablecimiento(@Param("nombre") String nombre, @Param("threshold") int threshold);
    
    @Query(value="select * from colegios c " +
             "where (:niveles is null or :niveles = 'nulo' or c.niveles like %:niveles%) " +
             "and (:jornadas is null or :jornadas = 'nulo' or c.jornadas like %:jornadas%) " +
             "and (:especialidad is null or :especialidad = 'nulo' or c.especialidad like %:especialidad%) " +
             "and (:modelos_educativos is null or :modelos_educativos = 'nulo' or c.modelos_educativos like %:modelos_educativos%) " +
             "and (:idiomas is null or :idiomas = 'nulo' or c.idiomas like %:idiomas%) " +
             "and (:calendario is null or :calendario = 'nulo' or c.calendario like %:calendario%) " +
             "and (:discapacidades is null or :discapacidades = 'nulo' or c.discapacidades like %:discapacidades%) " +
             "and (:prestador_de_servicio is null or :prestador_de_servicio = 'nulo' or c.prestador_de_servicio like %:prestador_de_servicio%)",
       nativeQuery=true)
       List<ColegiosEntity> findByNivel(@Param("niveles") String niveles,@Param("jornadas") String jornadas,@Param("especialidad") String especialidad ,@Param("modelos_educativos") String modelos_educativos ,@Param("idiomas") String idiomas ,@Param("calendario") String calendario, @Param("discapacidades") String discapacidades, @Param("prestador_de_servicio") String prestador_de_servicio);

       @Query(value = "SELECT distinct (niveles) FROM colegios", nativeQuery = true)
       List<String> findNiveles();

       @Query(value = "SELECT distinct (jornadas) FROM colegios", nativeQuery = true)
       List<String> findJornadas();

       @Query(value = "SELECT distinct (especialidad) FROM colegios", nativeQuery = true)
       List<String> findEspecialidad();

       @Query(value = "SELECT distinct (modelos_educativos) FROM colegios", nativeQuery = true)
       List<String> findModelosEducativos();

       @Query(value = "SELECT distinct (idiomas) FROM colegios", nativeQuery = true)
       List<String> findIdiomas();

       @Query(value = "SELECT distinct (calendario) FROM colegios", nativeQuery = true)
       List<String> findCalendario();

       @Query(value = "SELECT distinct (discapacidades) FROM colegios", nativeQuery = true)
       List<String> findDiscapacidades();

       @Query(value = "SELECT distinct (prestador_de_servicio) FROM colegios", nativeQuery = true)
       List<String> findPrestador();


}
