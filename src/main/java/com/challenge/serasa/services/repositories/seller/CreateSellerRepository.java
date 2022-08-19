package com.challenge.serasa.services.repositories.seller;

import com.challenge.serasa.infra.entities.SellerEntity;

public interface CreateSellerRepository {

    SellerEntity create(SellerEntity sellerToCreate);
}
