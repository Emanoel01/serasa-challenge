package com.challenge.serasa.main.factories.repositories;

import com.challenge.serasa.infra.repositories.SellerRepository;
import com.challenge.serasa.services.repositories.seller.CreateSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindAllSellerRepository;
import com.challenge.serasa.services.repositories.seller.FindSellerByIdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SellerRepositoryFactory {

    @Bean
    public CreateSellerRepository createSellerRepository(){
        return new SellerRepository();
    }

    @Bean
    public FindSellerByIdRepository findSellerByIdRepository (){return new SellerRepository();}

    @Bean
    public FindAllSellerRepository findAllSellerRepository(){return new SellerRepository();}

}
