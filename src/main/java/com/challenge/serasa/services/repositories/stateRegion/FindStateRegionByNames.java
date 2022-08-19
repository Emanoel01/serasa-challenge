package com.challenge.serasa.services.repositories.stateRegion;

import com.challenge.serasa.infra.entities.StateRegionEntity;

public interface FindStateRegionByNames {

    StateRegionEntity findByStateNameAndRegionName(String state, String region);

}
