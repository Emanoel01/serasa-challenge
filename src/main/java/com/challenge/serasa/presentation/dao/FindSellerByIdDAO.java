package com.challenge.serasa.presentation.dao;

import lombok.Data;

import java.util.Date;

@Data
public class FindSellerByIdDAO {

    private String nome;
    private Date dataInclusao;
    private String[] estados;

}
