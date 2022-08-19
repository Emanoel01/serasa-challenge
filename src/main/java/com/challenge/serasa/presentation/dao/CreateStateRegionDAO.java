package com.challenge.serasa.presentation.dao;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateStateRegionDAO {

    @NotBlank(message = "a região é obrigatória")
    public String regiao;

    public String[] estados;

}
