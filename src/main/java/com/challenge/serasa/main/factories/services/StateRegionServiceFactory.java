package com.challenge.serasa.main.factories.services;

import com.challenge.serasa.domain.usecases.CreateStateAndRegions;
import com.challenge.serasa.domain.usecases.FindStatesByRegionName;
import com.challenge.serasa.services.repositories.region.FindOrCreateRegionRepository;
import com.challenge.serasa.services.repositories.state.FindOrCreateStateRepository;
import com.challenge.serasa.services.repositories.stateRegion.CreateAllStateRegionRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindAllStateRegionByRegionNameRepository;
import com.challenge.serasa.services.usecases.stateRegion.CreateStateAndRegionsService;
import com.challenge.serasa.services.usecases.stateRegion.FindStatesByRegionNameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateRegionServiceFactory {

    @Bean
    public CreateStateAndRegions createStateAndRegions(
            FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository,
            FindOrCreateRegionRepository findOrCreateRegionRepository,
            FindOrCreateStateRepository findOrCreateStateRepository,
            CreateAllStateRegionRepository createAllStateRegionRepository
    ){
        return new CreateStateAndRegionsService(findAllStateRegionByRegionNameRepository,
                findOrCreateRegionRepository,findOrCreateStateRepository, createAllStateRegionRepository);
    }

    @Bean
    public FindStatesByRegionName findStatesByRegionName(FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository){
        return new FindStatesByRegionNameService(findAllStateRegionByRegionNameRepository);
    }

}
