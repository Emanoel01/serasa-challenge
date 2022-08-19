package com.challenge.serasa.services.repositories.region;

import com.challenge.serasa.infra.entities.RegionEntity;

public interface FindRegionByNameRepository {

    RegionEntity findByName(String name);

}
