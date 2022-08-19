package com.challenge.serasa.domain.usecases;

import com.challenge.serasa.domain.models.Seller;

import java.util.List;

public interface FindAllSellers {

    List<Seller> findAll() throws Exception;

}
