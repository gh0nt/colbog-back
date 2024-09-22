package com.colbog.colbogMs.repository;

import com.colbog.colbogMs.models.ColegiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegiosRepository extends JpaRepository<ColegiosEntity, Long> {

}
