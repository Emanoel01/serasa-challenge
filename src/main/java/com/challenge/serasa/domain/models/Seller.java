package com.challenge.serasa.domain.models;

import lombok.Data;

import java.util.Date;

@Data
public class Seller {

    private int id;
    private String phone;
    private Integer age;
    private String city;
    private String state;
    private String region;
    private Date createdAt;
    private String name;

}
