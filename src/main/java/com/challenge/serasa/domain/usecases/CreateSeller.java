package com.challenge.serasa.domain.usecases;

import com.challenge.serasa.domain.models.Seller;

public interface CreateSeller {

    Seller create(Seller sellerToCreate) throws Exception;

}
