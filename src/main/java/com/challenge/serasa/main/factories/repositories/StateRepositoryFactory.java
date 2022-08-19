package com.challenge.serasa.main.factories.repositories;

import com.challenge.serasa.infra.repositories.StateRepository;
import com.challenge.serasa.services.repositories.state.FindOrCreateStateRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateRepositoryFactory {

    @Bean
    public FindOrCreateStateRepository findOrCreateStateRepository (){
        return new StateRepository();
    }

}
