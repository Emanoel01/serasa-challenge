package com.challenge.serasa.main.factories.services;

import com.challenge.serasa.domain.usecases.CreateSeller;
import com.challenge.serasa.domain.usecases.FindAllSellers;
import com.challenge.serasa.domain.usecases.FindSellerById;
import com.challenge.serasa.services.repositories.seller.CreateSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindAllSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindSellerByIdRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindStateRegionByNames;
import com.challenge.serasa.services.usecases.seller.CreateSellerService;
import com.challenge.serasa.services.usecases.seller.FindAllSellersService;
import com.challenge.serasa.services.usecases.seller.FindSellerByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SellerServiceFactory {

    @Bean
    public CreateSeller createSeller(FindStateRegionByNames findStateRegionByNames, CreateSellerRepository createSellerRepository){
        return new CreateSellerService(findStateRegionByNames, createSellerRepository);
    }

    @Bean
    public FindSellerById findSellerById(FindSellerByIdRepository findSellerByIdRepository){
        return new FindSellerByIdService(findSellerByIdRepository);
    }

    @Bean
    public FindAllSellers findAllSellers(FindAllSellerRepository findAllSellerRepository){
        return new FindAllSellersService(findAllSellerRepository);
    }

}
