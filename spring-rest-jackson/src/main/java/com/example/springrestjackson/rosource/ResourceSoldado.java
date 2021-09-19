package com.example.springrestjackson.rosource;

import com.example.springrestjackson.controller.SoldadoController;
import com.example.springrestjackson.controller.response.SoldadoListResponse;
import com.example.springrestjackson.controller.response.SoldadoResponse;
import com.example.springrestjackson.entity.SoldadoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ResourceSoldado {
    private ObjectMapper objectMapper;

    public ResourceSoldado(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarLink(SoldadoEntity soldadoEntity) {
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo(methodOn(SoldadoController.class).buscarSoldado(soldadoEntity.getId())).withSelfRel();
        soldadoListResponse.add(link);
        return soldadoListResponse;
    }

    public SoldadoResponse criarLinkDetalhe(SoldadoEntity soldadoEntity) {
        SoldadoResponse soldadoListResponse = objectMapper.convertValue(soldadoEntity, SoldadoResponse.class);
        if(soldadoEntity.getStatus().equals("morto")){
            Link link = linkTo(methodOn(SoldadoController.class).deletarSoldado(soldadoEntity.getId()))
                    .withRel("remover")
                    .withTitle("Deletar soldado")
                    .withType("delete");
            soldadoListResponse.add(link);
        }else if(soldadoEntity.getStatus().equals("vivo")) {
            Link link = linkTo(methodOn(SoldadoController.class).frenteCastelo(soldadoEntity.getId()))
                    .withRel("batalhar")
                    .withTitle("Ir para frente do castelo")
                    .withType("put");
            soldadoListResponse.add(link);
        }
        return soldadoListResponse;
    }
}
