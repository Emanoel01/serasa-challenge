package com.challenge.serasa;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.infra.repositories.SellerRepository;
import com.challenge.serasa.infra.repositories.StateRegionRepository;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.services.usecases.seller.CreateSellerService;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreateSellerTest {

    @MockBean
    private StateRegionRepository stateRegionRepository;

    @MockBean
    private SellerRepository sellerRepository;

    private CreateSellerService factory(StateRegionRepository stateRegionRepository, SellerRepository sellerRepository){
        return new CreateSellerService(stateRegionRepository, sellerRepository);
    }

    private Seller createSeller(){
        Seller seller = new Seller();
        seller.setRegion("region");
        seller.setState("state");
        seller.setAge(50);
        seller.setCity("teste");
        seller.setPhone("11999999999");

        return seller;
    }


    @Test()
    public void shouldThrowWithIncorrectStateAndRegionName(){
        Seller seller = this.createSeller();

        CreateSellerService createSellerService = factory(stateRegionRepository, sellerRepository);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {createSellerService.create(seller);});

        Assertions.assertEquals(EXCEPTIONS.STATE_OR_REGION_NOT_FOUND.toString(), exception.getMessage());
    }

    @Before
    public void setup(){
        Seller seller = new Seller();
        seller.setRegion("region");
        seller.setState("state");
        seller.setAge(50);
        seller.setCity("teste");
        seller.setPhone("11999999999");
        seller.setId(1);

        SellerEntity sellerEntity = SellerAdapter.toSellerEntity(seller, new StateRegionEntity());

        Mockito.when(stateRegionRepository.findByStateNameAndRegionName("state", "region")).thenReturn(null);
        Mockito.when(sellerRepository.create(sellerEntity)).thenReturn(sellerEntity);

    }
}
