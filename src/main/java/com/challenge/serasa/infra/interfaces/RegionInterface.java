package com.challenge.serasa.infra.interfaces;

import com.challenge.serasa.infra.entities.RegionEntity;
import com.challenge.serasa.infra.entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionInterface extends JpaRepository<RegionEntity, Integer> {

    RegionEntity findByName(String name);

}
