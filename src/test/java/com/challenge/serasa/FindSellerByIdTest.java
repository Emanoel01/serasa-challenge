package com.challenge.serasa;

import com.challenge.serasa.infra.repositories.SellerRepository;
import com.challenge.serasa.services.usecases.seller.FindSellerByIdService;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FindSellerByIdTest {


    @MockBean
    private SellerRepository sellerRepository;

    private FindSellerByIdService service (){
        return new FindSellerByIdService(sellerRepository);
    }


    @Test
    public void shouldThrowNotFoundException(){
        Exception exception = Assertions.assertThrows(Exception.class,() -> {this.service().find(10);});

        Assertions.assertEquals(EXCEPTIONS.SELLER_NOT_FOUND.toString(), exception.getMessage());

    }

    @Before
    public void setup(){
        Mockito.when(sellerRepository.findById(10)).thenReturn(null);
    }


}
