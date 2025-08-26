package com.eafit.repository;

import com.eafit.model.Medicion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    
    List<Medicion> findByPacienteIdOrderByFechaDesc(Long pacienteId);
    
    Optional<Medicion> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);

    @Query(value = "SELECT * FROM medicion WHERE paciente_id = :pacienteId ORDER BY fecha DESC LIMIT 1", nativeQuery = true)
    Optional<Medicion> findLastMedicionByPacienteId(@Param("pacienteId") Long pacienteId);

}
