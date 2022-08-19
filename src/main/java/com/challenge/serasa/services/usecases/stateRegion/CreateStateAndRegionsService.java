package com.challenge.serasa.services.usecases.stateRegion;

import com.challenge.serasa.domain.usecases.CreateStateAndRegions;
import com.challenge.serasa.infra.entities.RegionEntity;
import com.challenge.serasa.infra.entities.StateEntity;
import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.services.repositories.region.FindOrCreateRegionRepository;
import com.challenge.serasa.services.repositories.state.FindOrCreateStateRepository;
import com.challenge.serasa.services.repositories.stateRegion.CreateAllStateRegionRepository;
import com.challenge.serasa.services.repositories.stateRegion.FindAllStateRegionByRegionNameRepository;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateStateAndRegionsService implements CreateStateAndRegions {

    private FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository;
    private FindOrCreateRegionRepository findOrCreateRegionRepository;
    private FindOrCreateStateRepository findOrCreateStateRepository;
    private CreateAllStateRegionRepository createAllStateRegionRepository;


    public CreateStateAndRegionsService(
            FindAllStateRegionByRegionNameRepository findAllStateRegionByRegionNameRepository,
            FindOrCreateRegionRepository findOrCreateRegionRepository,
            FindOrCreateStateRepository findOrCreateStateRepository,
            CreateAllStateRegionRepository createAllStateRegionRepository) {
        this.findAllStateRegionByRegionNameRepository = findAllStateRegionByRegionNameRepository;
        this.findOrCreateRegionRepository = findOrCreateRegionRepository;
        this.findOrCreateStateRepository = findOrCreateStateRepository;
        this.createAllStateRegionRepository = createAllStateRegionRepository;
    }

    @Override
    public Boolean create(String region, String[] states) throws Exception {

        List<StateRegionEntity> allSaved = this.findAllStateRegionByRegionNameRepository.findAllByRegionName(region);

        List<String> statesSaved = allSaved != null && allSaved.size() > 0 ? allSaved.stream().map(v -> v.getState().getName()).collect(Collectors.toList()) : Arrays.asList();

        String[] statesNotSave =  statesSaved.size() == 0 ? states :  Arrays.stream(states).filter(v -> {
            if(!statesSaved.contains(v)) return true;
            return false;
        }).toArray(String[]::new);

        if(statesNotSave.length > 0){

            RegionEntity regionEntity = this.findOrCreateRegionRepository.findOrCreate(region);

            if(regionEntity == null) throw  new Exception(EXCEPTIONS.REGION_COULD_NOT_BE_CREATED.toString());

            List<StateRegionEntity> stateRegionsToCreate = Arrays.stream(statesNotSave).map(state -> {

               try {
                   StateEntity stateEntity = this.findOrCreateStateRepository.findOrCreate(state);

                   if(stateEntity == null) throw new Exception(EXCEPTIONS.STATE_COULD_NOT_BE_CREATED.toString());

                   StateRegionEntity stateRegionEntity = new StateRegionEntity(regionEntity, stateEntity);

                   return stateRegionEntity;

               }catch (Exception e){
                    throw new RuntimeException();
               }

            }).collect(Collectors.toList());


            Boolean created = this.createAllStateRegionRepository.create(stateRegionsToCreate);

            if(!created) throw  new Exception(EXCEPTIONS.STATE_REGION_COULD_NOT_BE_CREATED.toString());

        }

        return true;
    }
}
