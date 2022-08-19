package com.challenge.serasa.services.usecases.stateRegion;

import com.challenge.serasa.domain.usecases.FindStatesByRegionName;
import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.services.repositories.stateRegion.FindAllStateRegionByRegionNameRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindStateRegionByNames;

import java.util.List;

public class FindStatesByRegionNameService implements FindStatesByRegionName {

    private FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository;

    public FindStatesByRegionNameService(FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository) {
        this.findAllStateRegionByRegionNameRepository = findAllStateRegionByRegionNameRepository;
    }

    @Override
    public String[] findByRegionName(String name) {


        List<StateRegionEntity> all = this.findAllStateRegionByRegionNameRepository.findAllByRegionName(name);

        if(all == null || all.size() == 0) return new String[]{};

        return all.stream().map(sre -> sre.getState().getName()).toArray(String[]::new);
    }
}
