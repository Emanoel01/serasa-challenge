package com.challenge.serasa.services.usecases.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.FindAllSellers;
import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.services.repositories.seller.FindAllSellerRepository;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;

import java.util.List;

public class FindAllSellersService implements FindAllSellers {

    private FindAllSellerRepository findAllSellerRepository;

    public FindAllSellersService(FindAllSellerRepository findAllSellerRepository) {
        this.findAllSellerRepository = findAllSellerRepository;
    }

    @Override
    public List<Seller> findAll() throws Exception {
        List<SellerEntity> sellerEntities = this.findAllSellerRepository.findAll();

        if(sellerEntities == null || sellerEntities.size() == 0) throw  new Exception(EXCEPTIONS.SELLER_NOT_FOUND.toString());


        return SellerAdapter.toSellerList(sellerEntities);
    }
}
