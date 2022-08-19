package com.challenge.serasa.services.usecases.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.FindSellerById;
import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.services.repositories.seller.FindSellerByIdRepository;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;

public class FindSellerByIdService implements FindSellerById {

    private FindSellerByIdRepository findSellerByIdRepository;

    public FindSellerByIdService(FindSellerByIdRepository findSellerByIdRepository) {
        this.findSellerByIdRepository = findSellerByIdRepository;
    }

    @Override
    public Seller find(Integer id) throws Exception {

        SellerEntity sellerEntity = this.findSellerByIdRepository.findById(id);

        if(sellerEntity == null) throw new Exception(EXCEPTIONS.SELLER_NOT_FOUND.toString());

        return SellerAdapter.toSeller(sellerEntity);
    }
}
