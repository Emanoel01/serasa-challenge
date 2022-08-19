package com.challenge.serasa.infra.repositories;

import com.challenge.serasa.domain.models.State;
import com.challenge.serasa.infra.entities.StateEntity;
import com.challenge.serasa.infra.interfaces.StateInterface;
import com.challenge.serasa.services.repositories.state.FindOrCreateStateRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StateRepository implements FindOrCreateStateRepository {

    @Autowired
    private StateInterface stateInterface;

    @Override
    public StateEntity findOrCreate(String name) {
        StateEntity stateEntity = this.stateInterface.findByName(name);

        if(stateEntity == null) return this.stateInterface.save(new StateEntity(name));

        return stateEntity;
    }
}
