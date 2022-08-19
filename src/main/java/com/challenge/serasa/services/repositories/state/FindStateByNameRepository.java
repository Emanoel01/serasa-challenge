package com.challenge.serasa.services.repositories.state;

import com.challenge.serasa.infra.entities.StateEntity;

public interface FindStateByNameRepository {

    StateEntity findByName(String name);

}
