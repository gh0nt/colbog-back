package com.colbog.colbogMs.service;

import com.colbog.colbogMs.models.ColegiosEntity;
import com.colbog.colbogMs.repository.ColegiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColegiosService {
    @Autowired
    private ColegiosRepository colegiosRepository;

    private static final int SIMILARITY_THRESHOLD = 4;

    public List<ColegiosEntity> findAll(){
        return colegiosRepository.findAll();
    }

    public Optional<ColegiosEntity> findColegio(Long id){
        return colegiosRepository.findById(id);
    }

    public Page<ColegiosEntity> findPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return colegiosRepository.findAll(pageable);
    }


    public boolean save(ColegiosEntity colegio){
        if(isNombreSimilar(colegio.getNombreEstablecimiento())){
            return false;
        }
        colegiosRepository.save(colegio);
        return true;
    }

    private boolean isNombreSimilar(String nombre) {
        List<ColegiosEntity> colegios = colegiosRepository.findByNombreEstablecimiento(nombre,calculateDynamicThreshold(nombre));
        return !colegios.isEmpty();
    }

    private int calculateDynamicThreshold(String nombre) {
        int length = nombre.length();
        if (length <= 10) {
            return 3; // Nombres cortos, umbral bajo
        } else if (length <= 20) {
            return 5; // Nombres medianos, umbral moderado
        } else {
            return 8; // Nombres largos, umbral más relajado
        }
    }


    public boolean update(ColegiosEntity colegio){
        Optional<ColegiosEntity> scol = colegiosRepository.findById(colegio.getId());
        if (scol.isPresent()){
            colegiosRepository.save(colegio);
            return true;
        }
        return false;
    }

    public boolean delete(Long id){
        Optional<ColegiosEntity> scol = colegiosRepository.findById(id);
        if (scol.isPresent()){
            colegiosRepository.delete(scol.get());
            return true;
        }
        return false;
    }

    public List<ColegiosEntity> findFilter(String niveles, String jornadas, String especialidad, String modelos_educativos, String idiomas, String calendario, String discapacidades, String prestador_de_servicio) {
        //Pageable pageable = PageRequest.of(page, size);
        return colegiosRepository.findByNivel(niveles, jornadas, especialidad, modelos_educativos, idiomas, calendario, discapacidades, prestador_de_servicio);
    }

    public List<String> findNiveles(){
        return colegiosRepository.findNiveles();
    }

    public List<String> findJornadas(){
        return colegiosRepository.findJornadas();
    }

    public List<String> findEspecialidad(){
        return colegiosRepository.findEspecialidad();
    }

    public List<String> findModelosEducativos(){
        return colegiosRepository.findModelosEducativos();
    }

    public List<String> findIdiomas(){
        return colegiosRepository.findIdiomas();
    }

    public List<String> findCalendario(){
        return colegiosRepository.findCalendario();
    }

    public List<String> findDiscapacidades(){
        return colegiosRepository.findDiscapacidades();
    }

    public List<String> findPrestador(){
        return colegiosRepository.findPrestador();
    }
    
}
