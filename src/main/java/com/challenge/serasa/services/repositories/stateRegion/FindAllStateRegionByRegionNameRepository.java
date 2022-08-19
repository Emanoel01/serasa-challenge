package com.challenge.serasa.services.repositories.stateRegion;

import com.challenge.serasa.infra.entities.StateRegionEntity;

import java.util.List;

public interface FindAllStateRegionByRegionNameRepository {

    List<StateRegionEntity> findAllByRegionName(String name);

}
