package com.challenge.serasa.services.repositories.state;

import com.challenge.serasa.infra.entities.StateEntity;

public interface FindOrCreateStateRepository {

    StateEntity findOrCreate(String name);

}
