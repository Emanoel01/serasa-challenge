package com.challenge.serasa.services.usecases.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.CreateSeller;
import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.services.repositories.seller.CreateSellerRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindStateRegionByNames;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;

public class CreateSellerService implements CreateSeller {

    private FindStateRegionByNames findStateRegionByNames;
    private CreateSellerRepository createSellerRepository;

    public CreateSellerService(FindStateRegionByNames findStateRegionByNames, CreateSellerRepository createSellerRepository) {
        this.findStateRegionByNames = findStateRegionByNames;
        this.createSellerRepository = createSellerRepository;
    }

    @Override
    public Seller create(Seller sellerToCreate) throws Exception {

        StateRegionEntity stateRegionEntity = this.findStateRegionByNames.findByStateNameAndRegionName(sellerToCreate.getState(),  sellerToCreate.getRegion());
        if(stateRegionEntity == null) throw  new Exception(EXCEPTIONS.STATE_OR_REGION_NOT_FOUND.toString());

        SellerEntity sellerCreated = this.createSellerRepository.create(SellerAdapter.toSellerEntity(sellerToCreate, stateRegionEntity));

        if(sellerCreated.getId() == null) throw  new Exception(EXCEPTIONS.SELLER_NOT_CREATE.toString());

        return SellerAdapter.toSeller(sellerCreated);
    }
}
