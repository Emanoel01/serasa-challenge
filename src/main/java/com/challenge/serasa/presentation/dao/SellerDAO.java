package com.challenge.serasa.presentation.dao;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class SellerDAO {

    private Integer id;

    @NotBlank(message = "o nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "telefone não pode ser nulo")
    private String telefone;

    @NotNull(message = "idade é obrigatória")
    @Min(value = 18, message = "A idade minima é de 18 anos")
    private Integer idade;

    @NotBlank(message = "cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "estado é obrigatório")
    private String estado;

    @NotBlank(message = "regiao é obrigatório")
    private String regiao;

    private Date dataInclusao;

}
