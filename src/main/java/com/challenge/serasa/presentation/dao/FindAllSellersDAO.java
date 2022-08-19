package com.challenge.serasa.presentation.dao;

import lombok.Data;

import java.util.Date;

@Data
public class FindAllSellersDAO {

    private String nome;

    private String telefone;

    private Integer idade;

    private String cidade;

    private String estado;

    private String regiao;

    private Date dataInclusao;

    private String[] estados;

}
