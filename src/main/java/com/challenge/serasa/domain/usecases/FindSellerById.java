package com.challenge.serasa.domain.usecases;

import com.challenge.serasa.domain.models.Seller;

public interface FindSellerById {

    Seller find(Integer id) throws Exception;

}
