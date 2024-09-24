package com.colbog.colbogMs.repository;

import com.colbog.colbogMs.models.ColegiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColegiosRepository extends JpaRepository<ColegiosEntity, Long> {
    @Query(value = "SELECT * FROM colegios e WHERE levenshtein(e.nombreestablecimiento, :nombre) <= :threshold", nativeQuery = true)
    List<ColegiosEntity> findByNombreEstablecimiento(@Param("nombre") String nombre, @Param("threshold") int threshold);

}
