package com.example.springrestjaxrs.service;

import com.example.springrestjaxrs.dto.SoldadoEditDTO;
import com.example.springrestjaxrs.entity.Soldado;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {

    public List<Soldado> buscarSoldados() {
        Soldado soldado1 = new Soldado();
        soldado1.setCpf("123456789");
        soldado1.setNome("Legolas");
        soldado1.setRaca("Elfo");
        soldado1.setArma("Arco e flexa");
        Soldado soldado2 = new Soldado();
        soldado2.setCpf("987654321");
        soldado2.setNome("Paloma");
        soldado2.setRaca("Elfa");
        soldado2.setArma("Arco e flexa");
        return Arrays.asList(soldado1,soldado2);
    }

    public Soldado buscarSoldado(String cpf) {
        Soldado soldado = new Soldado();
        soldado.setCpf(cpf);
        soldado.setNome("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e flexa");
        return soldado;
    }

    public void criarSoldado(Soldado soldado) {
    }

    public void alterarSoldado(String cpf, SoldadoEditDTO soldadoEditRequest) {
    }

    public void deletarSoldado(String cpf) {
    }
}
