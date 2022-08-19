package com.challenge.serasa.services.repositories.seller;

import com.challenge.serasa.infra.entities.SellerEntity;

public interface FindSellerByIdRepository {

    SellerEntity findById(Integer id);

}
