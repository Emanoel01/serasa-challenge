package com.challenge.serasa.infra.interfaces;

import com.challenge.serasa.infra.entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateInterface extends JpaRepository<StateEntity, Integer> {

    StateEntity findByName(String name);

}
