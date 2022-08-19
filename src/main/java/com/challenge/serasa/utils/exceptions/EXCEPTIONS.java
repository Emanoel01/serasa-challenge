package com.challenge.serasa.utils.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public enum EXCEPTIONS {

    STATE_NOT_FOUND(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("Estado informado não foi encontrado em nossa base, revise os dados e tente novamente"))),
    REGION_NOT_FOUND(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("Região informada não pode ser encontrada, revise os dados e tente novamente"))),
    SELLER_NOT_CREATE(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("O vendedor não pode ser criado, revise os dads e tente novamente"))),
    STATE_OR_REGION_NOT_FOUND(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("Os dados da região e/ou estado não puderam ser encontrados, certifique-se que ambos estão em nossa base de dados"))),
    INTERNAL_SERVER_ERROR(ResponseEntity.internalServerError().contentType(MediaType.APPLICATION_JSON).body(formatMessage("ocorreram alguns erros"))),
    REGION_COULD_NOT_BE_CREATED(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("A região não pode ser criada, por favor tente novamente mais tarde"))),
    STATE_COULD_NOT_BE_CREATED(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("o estado  não pode ser criada, por favor tente novamente mais tarde"))),
    STATE_REGION_COULD_NOT_BE_CREATED(ResponseEntity.internalServerError().contentType(MediaType.APPLICATION_JSON).body(formatMessage("A regiaõ e os estados não puderam ser criado, por favor tente novamente mais tarde"))),
    STATE_MUST_CONTAIN_TWO_LETTERS(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("o estado deve conter 2 letras"))),
    STATES_COULD_NOT_BE_EMPTY(ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(formatMessage("A lista de estados não pode ser nula"))),
    SELLER_NOT_FOUND(ResponseEntity.noContent().build());

    private ResponseEntity responseEntity;


    EXCEPTIONS(ResponseEntity responseEntity){
        this.responseEntity = responseEntity;
    }


    public final ResponseEntity getResponseEntity(){
        return this.responseEntity;
    }

    private static String formatMessage(String message){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = String.format("{ \"message\":  \"%s\"}", message);
            return objectMapper.readValue(objectMapper.writeValueAsString(json), String.class);
        }catch (Exception e){
            e.printStackTrace();
            return "Ocorreram alguns erros";
        }
    }


}
