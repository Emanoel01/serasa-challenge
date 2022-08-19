package com.challenge.serasa.infra.interfaces;

import com.challenge.serasa.infra.entities.StateRegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRegionInterface extends JpaRepository<StateRegionEntity, Integer> {

    StateRegionEntity findByStateNameAndRegionName(String stateName, String regionName);

    List<StateRegionEntity> findAllByRegionName(String name);

}
