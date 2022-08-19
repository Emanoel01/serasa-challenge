package com.challenge.serasa.services.facades.sellers;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.presentation.dao.FindAllSellersDAO;

import java.util.List;

public interface FindAllSellersFacade {

    List<FindAllSellersDAO> handle(List<Seller> seller);

}
