package com.challenge.serasa.services.repositories.seller;

import com.challenge.serasa.infra.entities.SellerEntity;

import java.util.List;

public interface FindAllSellerRepository {

    List<SellerEntity> findAll();

}
