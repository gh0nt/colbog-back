package com.colbog.colbogMs.service;

import com.colbog.colbogMs.models.ColegiosEntity;
import com.colbog.colbogMs.repository.ColegiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegiosService {
    @Autowired
    private ColegiosRepository colegiosRepository;

    public List<ColegiosEntity> findAll(){
        return colegiosRepository.findAll();
    }

    public Page<ColegiosEntity> findPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return colegiosRepository.findAll(pageable);
    }

    public List<ColegiosEntity> findFilter(String niveles, String jornadas, String especialidad, String modelos_educativos, String idiomas, String calendario, String discapacidades, String prestador_de_servicio) {
        //Pageable pageable = PageRequest.of(page, size);
        return colegiosRepository.findByNivel(niveles, jornadas, especialidad, modelos_educativos, idiomas, calendario, discapacidades, prestador_de_servicio);
    }
}
