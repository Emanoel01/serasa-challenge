package com.challenge.serasa.presentation.controllers.stateRegion;

import com.challenge.serasa.domain.usecases.CreateStateAndRegions;
import com.challenge.serasa.presentation.dao.CreateStateRegionDAO;
import com.challenge.serasa.presentation.dao.SellerDAO;
import com.challenge.serasa.services.usecases.stateRegion.CreateStateAndRegionsService;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("/atuacao")
public class CreateStateRegionController {

    @Autowired
    private Validator validator;


    private CreateStateAndRegions createStateAndRegions;

    public CreateStateRegionController(CreateStateAndRegions createStateAndRegions) {
        this.createStateAndRegions = createStateAndRegions;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CreateStateRegionDAO dao){
        try{

            Set<ConstraintViolation<CreateStateRegionDAO>> errors = validator.validate(dao);

            if(!errors.isEmpty()){
                return ResponseEntity.badRequest().body(errors.stream().map( e -> e.getMessage()));
            }

            if(dao.getEstados().length == 0){
                return EXCEPTIONS.STATES_COULD_NOT_BE_EMPTY.getResponseEntity();
            }else{
                for(String estado: dao.getEstados()){
                    if(estado.length() != 2) throw  new Exception(EXCEPTIONS.STATE_MUST_CONTAIN_TWO_LETTERS.toString());
                }
            }

            this.createStateAndRegions.create(dao.getRegiao(), dao.getEstados());


            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri()
            ).body(null);
        }catch (Exception e){
            e.printStackTrace();
            EXCEPTIONS exception = EXCEPTIONS.valueOf(e.getMessage());

            if(exception != null) return exception.getResponseEntity();

            return EXCEPTIONS.INTERNAL_SERVER_ERROR.getResponseEntity();

        }
    }

}
