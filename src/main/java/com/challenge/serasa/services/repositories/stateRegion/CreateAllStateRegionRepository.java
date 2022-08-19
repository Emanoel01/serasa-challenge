package com.challenge.serasa.services.repositories.stateRegion;

import com.challenge.serasa.infra.entities.StateRegionEntity;

import java.util.List;

public interface CreateAllStateRegionRepository {

    Boolean create(List<StateRegionEntity> stateRegionEntity);

}
