package com.eafit.repository;

import com.eafit.model.Nutricionista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {   
    @Query("SELECT n FROM Nutricionista n LEFT JOIN FETCH n.pacientes WHERE n.id = :id")
    Optional<Nutricionista> findByIdWithPacientes(@Param("id") Long id);
}
