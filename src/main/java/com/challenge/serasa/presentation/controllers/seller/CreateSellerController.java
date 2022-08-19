package com.challenge.serasa.presentation.controllers.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.CreateSeller;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.presentation.dao.SellerDAO;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@RequestMapping("/vendedor")
public class CreateSellerController {

    private CreateSeller createSeller;

    public CreateSellerController(CreateSeller createSeller) {
        this.createSeller = createSeller;
    }

    @Autowired
    private Validator validator;

    @PostMapping
    public ResponseEntity create(@RequestBody  SellerDAO sellerDAO){
        try {

            Set<ConstraintViolation<SellerDAO>> errors = validator.validate(sellerDAO);

            if(!errors.isEmpty()){
                return ResponseEntity.badRequest().body(errors.stream().map( e -> e.getMessage()));
            }


            Seller seller = this.createSeller.create(SellerAdapter.toSeller(sellerDAO));

            sellerDAO.setId(seller.getId());
            sellerDAO.setDataInclusao(seller.getCreatedAt());

            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sellerDAO).toUri()
            ).body(sellerDAO);
        }catch (Exception e){


            e.printStackTrace();

            EXCEPTIONS exception = EXCEPTIONS.valueOf(e.getMessage());

            if(exception != null)return exception.getResponseEntity();

            return EXCEPTIONS.INTERNAL_SERVER_ERROR.getResponseEntity();

        }
    }

}
