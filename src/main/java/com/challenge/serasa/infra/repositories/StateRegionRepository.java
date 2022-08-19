package com.challenge.serasa.infra.repositories;

import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.infra.interfaces.StateRegionInterface;
import com.challenge.serasa.services.repositories.stateRegion.CreateAllStateRegionRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindAllStateRegionByRegionNameRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindStateRegionByNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;


public class StateRegionRepository implements FindStateRegionByNames, FindAllStateRegionByRegionNameRepository, CreateAllStateRegionRepository {

    @Autowired
    private StateRegionInterface stateRegionInterface;


    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public StateRegionEntity findByStateNameAndRegionName(String state, String region) {
        return this.stateRegionInterface.findByStateNameAndRegionName(state, region);
    }

    @Override
    public List<StateRegionEntity> findAllByRegionName(String name) {
        return this.stateRegionInterface.findAllByRegionName(name);
    }

    @Override
    public Boolean create(List<StateRegionEntity> stateRegionEntities) {

        EntityManager entityManager = this.entityManagerFactory.createEntityManager();

        try {

            entityManager.getTransaction().begin();


            for (StateRegionEntity entity: stateRegionEntities) entityManager.persist(entity);


            entityManager.getTransaction().commit();

            return true;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
