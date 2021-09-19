package com.example.springresthateoas.service;

import com.example.springresthateoas.controller.response.SoldadoListResponse;
import com.example.springresthateoas.mapper.SoldadoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.springresthateoas.controller.request.SoldadoEditRequest;
import com.example.springresthateoas.controller.response.SoldadoResponse;
import com.example.springresthateoas.dto.Soldado;
import com.example.springresthateoas.entity.SoldadoEntity;
import com.example.springresthateoas.repostory.SoldadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private SoldadoRepository soldadoRepository;
    private ObjectMapper objectMapper;
    private SoldadoMapper soldadoMapper;

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper, SoldadoMapper soldadoMapper) {
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
        this.soldadoMapper = soldadoMapper;
    }

    public SoldadoResponse buscarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
        return soldadoResponse;
    }

    public void criarSoldado(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        soldadoRepository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow();
        soldadoRepository.delete(soldado);
    }

    public List<SoldadoListResponse> buscarSoldados(){
        List<SoldadoEntity> all = soldadoRepository.findAll();
        List<SoldadoListResponse> soldadoStream = all.stream()
                .map(it -> soldadoMapper.criarLink(it))
                .collect(Collectors.toList());
        return soldadoStream;
    }
}
