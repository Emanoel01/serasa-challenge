package com.challenge.serasa;


import com.challenge.serasa.infra.entities.RegionEntity;
import com.challenge.serasa.infra.entities.StateEntity;
import com.challenge.serasa.infra.repositories.RegionRepository;
import com.challenge.serasa.infra.repositories.StateRegionRepository;
import com.challenge.serasa.infra.repositories.StateRepository;
import com.challenge.serasa.services.usecases.stateRegion.CreateStateAndRegionsService;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreateStateRegionTest {

    @MockBean
    private StateRegionRepository stateRegionRepository;

    @MockBean
    private StateRepository stateRepository;

    @MockBean
    private RegionRepository regionRepository;

    private CreateStateAndRegionsService factory (){
        return new CreateStateAndRegionsService(stateRegionRepository, regionRepository, stateRepository, stateRegionRepository);
    }

    @Test
    public void shouldThrowAnExceptionWhenTryToSaveRegion(){

        String region  ="region";
        String[] states = {"state","otherState"};

        CreateStateAndRegionsService service = this.factory();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {service.create(region, states);});

        Assertions.assertEquals(exception.getMessage(), EXCEPTIONS.REGION_COULD_NOT_BE_CREATED.toString());

    }



    @Before
    public void setup(){
        StateEntity stateEntity = new StateEntity("entity1");
        StateEntity stateEntity2 = new StateEntity("entity2");

        RegionEntity regionEntity = new RegionEntity("region");

        Mockito.when(stateRegionRepository.findAllByRegionName("region")).thenReturn(null);
        Mockito.when(regionRepository.findOrCreate("region")).thenReturn(null);

    }


}
