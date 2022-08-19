package com.challenge.serasa.infra.repositories;

import com.challenge.serasa.infra.entities.RegionEntity;
import com.challenge.serasa.infra.interfaces.RegionInterface;
import com.challenge.serasa.services.repositories.region.FindOrCreateRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegionRepository implements FindOrCreateRegionRepository {

    @Autowired
    private RegionInterface regionInterface;

    @Override
    public RegionEntity findOrCreate(String name) {
        RegionEntity regionEntity = this.regionInterface.findByName(name);

        if(regionEntity == null) return this.regionInterface.save(new RegionEntity(name));

        return regionEntity;
    }
}
