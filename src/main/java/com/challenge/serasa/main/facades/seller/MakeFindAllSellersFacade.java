package com.challenge.serasa.main.facades.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.FindStatesByRegionName;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.presentation.dao.FindAllSellersDAO;
import com.challenge.serasa.services.facades.sellers.FindAllSellersFacade;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MakeFindAllSellersFacade implements FindAllSellersFacade {


    private FindStatesByRegionName findStatesByRegionName;

    public MakeFindAllSellersFacade(FindStatesByRegionName findStatesByRegionName) {
        this.findStatesByRegionName = findStatesByRegionName;
    }

    @Override
    public List<FindAllSellersDAO> handle(List<Seller> sellers) {
        List<FindAllSellersDAO> result = sellers.stream().map(s -> {
            String[] states = this.findStatesByRegionName.findByRegionName(s.getRegion());
            FindAllSellersDAO dao = SellerAdapter.toFindAllSellersDAO(s, states);
            return dao;
        }).collect(Collectors.toList());


        return result;
    }
}
