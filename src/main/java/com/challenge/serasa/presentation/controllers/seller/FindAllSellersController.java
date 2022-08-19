package com.challenge.serasa.presentation.controllers.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.FindAllSellers;
import com.challenge.serasa.presentation.dao.FindAllSellersDAO;
import com.challenge.serasa.services.facades.sellers.FindAllSellersFacade;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class FindAllSellersController {


    private FindAllSellers findAllSellers;
    private FindAllSellersFacade findAllSellersFacade;


    public FindAllSellersController(FindAllSellers findAllSellers, FindAllSellersFacade findAllSellersFacade) {
        this.findAllSellers = findAllSellers;
        this.findAllSellersFacade = findAllSellersFacade;
    }

    @GetMapping
    public ResponseEntity getAll(){
        try{

            List<Seller> sellers = this.findAllSellers.findAll();

            List<FindAllSellersDAO> result = this.findAllSellersFacade.handle(sellers);

            return ResponseEntity.ok(result);
        }catch (Exception e){
            EXCEPTIONS exception = EXCEPTIONS.valueOf(e.getMessage());

            if(exception != null) return exception.getResponseEntity();

            return EXCEPTIONS.INTERNAL_SERVER_ERROR.getResponseEntity();

        }
    }

}
