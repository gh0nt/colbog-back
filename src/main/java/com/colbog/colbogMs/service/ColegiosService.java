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
}
