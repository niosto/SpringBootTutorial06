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
public class MedicionServiceAutowired {
    
    // Inyección de dependencias a nivel de campo usando @Autowired
    @Autowired
    private MedicionRepository medicionRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private NutricionistaRepository nutricionistaRepository;
    
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

