package com.example.springweb.service;

import com.example.springweb.client.FeingClient;
import com.example.springweb.client.JavaHttpClient;
import com.example.springweb.client.RestTemplateClient;
import com.example.springweb.dto.MessageSend;
import com.example.springweb.dto.ResultBotTelegram;
import com.example.springweb.dto.ResultBotTelegramList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Telegram {
    private RestTemplateClient restTemplateClient;
    private FeingClient feingClient;
    private JavaHttpClient javaHttpClient;

    public Telegram(RestTemplateClient restTemplateClient, FeingClient feingClient, JavaHttpClient javaHttpClient) {
        this.restTemplateClient = restTemplateClient;
        this.feingClient = feingClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void enviarMensagem(MessageSend mensagem) {
        //HTTP CLIENT
        ResultBotTelegram resultBotTelegramResponseEntity = javaHttpClient.enviarMensagem(mensagem);

        //RestTemplate
        //restTemplateClient.enviarMensagem(mensagem);

        //FeingClient
        //ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
    }

    public ResultBotTelegramList buscarAtualizacao() {
        //HTTP CLIENT
        ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualizacao();

        //RestTemplate
        ResultBotTelegramList resultBotTelegramList1 = restTemplateClient.buscarAtualizacao();

        //FeingClient
        feingClient.buscaratualizacao();
        return resultBotTelegramList;
    }
}
