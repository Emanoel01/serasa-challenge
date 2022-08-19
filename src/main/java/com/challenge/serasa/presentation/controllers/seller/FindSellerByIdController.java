package com.challenge.serasa.presentation.controllers.seller;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.domain.usecases.FindSellerById;
import com.challenge.serasa.domain.usecases.FindStatesByRegionName;
import com.challenge.serasa.main.adapters.SellerAdapter;
import com.challenge.serasa.utils.exceptions.EXCEPTIONS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
public class FindSellerByIdController {

    private FindSellerById findSellerById;
    private FindStatesByRegionName findStatesByRegionName;

    public FindSellerByIdController(FindSellerById findSellerById, FindStatesByRegionName findStatesByRegionName) {
        this.findSellerById = findSellerById;
        this.findStatesByRegionName = findStatesByRegionName;
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        try {
            Seller seller = this.findSellerById.find(id);
            String[] states = this.findStatesByRegionName.findByRegionName(seller.getRegion());

            return ResponseEntity.ok(SellerAdapter.toFindSellerByIdDAO(seller, states));
        }catch (Exception e){
            EXCEPTIONS exception = EXCEPTIONS.valueOf(e.getMessage());

            if(exception != null) return exception.getResponseEntity();


            return EXCEPTIONS.INTERNAL_SERVER_ERROR.getResponseEntity();

        }
    }
}
