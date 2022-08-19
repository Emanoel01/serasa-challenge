package com.challenge.serasa;

import com.challenge.serasa.infra.repositories.StateRegionRepository;
import com.challenge.serasa.services.usecases.stateRegion.FindStatesByRegionNameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FindStatesByRegionNameTest {


    @MockBean
    private StateRegionRepository stateRegionRepository;

    public FindStatesByRegionNameService service(){
        return new FindStatesByRegionNameService(stateRegionRepository);
    }

    @Test
    public void shouldReturnAnEmptyArray(){

        FindStatesByRegionNameService service = this.service();

        Assertions.assertArrayEquals(new String[]{}, service.findByRegionName("region"));

    }

    @Before
    public void setup(){
        Mockito.when(stateRegionRepository.findAllByRegionName("region")).thenReturn(null);
    }

}
