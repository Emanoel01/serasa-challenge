package com.challenge.serasa.main.facades.config;

import com.challenge.serasa.domain.usecases.FindStatesByRegionName;
import com.challenge.serasa.main.facades.seller.MakeFindAllSellersFacade;
import com.challenge.serasa.services.facades.sellers.FindAllSellersFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllSellersFacadeConfig {

    @Bean
    public FindAllSellersFacade findAllSellersFacade(FindStatesByRegionName findStatesByRegionName){
        return new MakeFindAllSellersFacade(findStatesByRegionName);
    }

}
