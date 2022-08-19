package com.challenge.serasa.infra.repositories;

import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.infra.interfaces.SellerInterface;
import com.challenge.serasa.services.repositories.seller.CreateSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindAllSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindSellerByIdRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SellerRepository implements CreateSellerRepository, FindSellerByIdRepository, FindAllSellerRepository {

    @Autowired
    private SellerInterface sellerInterface;

    @Override
    public SellerEntity create(SellerEntity sellerToCreate) {
        return this.sellerInterface.save(sellerToCreate);
    }

    @Override
    public SellerEntity findById(Integer id) {
        return this.sellerInterface.findById(id).orElse(null);
    }

    @Override
    public List<SellerEntity> findAll() {
        return this.sellerInterface.findAll();
    }
}
