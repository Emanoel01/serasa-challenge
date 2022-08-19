package com.challenge.serasa.domain.models;

import lombok.Data;

import java.util.List;

@Data
public class Region {

    private Integer id;
    private String name;
    private List<State> states;

}
