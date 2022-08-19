package com.challenge.serasa.main.factories.repositories;

import com.challenge.serasa.infra.repositories.RegionRepository;
import com.challenge.serasa.services.repositories.region.FindOrCreateRegionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegionRepositoryFactory {

    @Bean
    public FindOrCreateRegionRepository findOrCreateRegionRepository(){
        return new RegionRepository();
    }

}
