package com.challenge.serasa.main.factories.repositories;

import com.challenge.serasa.infra.repositories.StateRegionRepository;
import com.challenge.serasa.services.repositories.stateRegion.CreateAllStateRegionRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindAllStateRegionByRegionNameRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindStateRegionByNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateRegionRepositoryFactory {

    @Bean
    public FindStateRegionByNames findStateRegionByNames(){
        return new StateRegionRepository();
    }

    @Bean
    public CreateAllStateRegionRepository createAllStateRegionRepository(){
        return new StateRegionRepository();
    }

    @Bean
    public FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository(){return new StateRegionRepository();}
}
