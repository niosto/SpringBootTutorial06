package com.eafit.service;

import com.eafit.model.Medicion;
import com.eafit.repository.MedicionRepository;
import com.eafit.repository.PacienteRepository;
import com.eafit.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicionServiceSetter {
    
    // Declaración de los repositorios necesarios
    private MedicionRepository medicionRepository;
    private PacienteRepository pacienteRepository;
    private NutricionistaRepository nutricionistaRepository;
    
    // Setter para inyectar el MedicionRepository
    @Autowired
    public void setMedicionRepository(MedicionRepository medicionRepository) {
        this.medicionRepository = medicionRepository;
    }
    
    // Setter para inyectar el PacienteRepository
    @Autowired
    public void setPacienteRepository(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    
    // Setter para inyectar el NutricionistaRepository
    @Autowired
    public void setNutricionistaRepository(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }
    
    @Transactional(readOnly = true)
    public List<Medicion> findAll() {
        return medicionRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Medicion> findById(Long id) {
        return medicionRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Medicion> findLastMedicionByPacienteId(Long id) {
        return medicionRepository.findLastMedicionByPacienteId(id);
    }
    
}
