package com.challenge.serasa.main.adapters;

import com.challenge.serasa.domain.models.Seller;
import com.challenge.serasa.infra.entities.SellerEntity;
import com.challenge.serasa.infra.entities.StateRegionEntity;
import com.challenge.serasa.presentation.dao.FindAllSellersDAO;
import com.challenge.serasa.presentation.dao.FindSellerByIdDAO;
import com.challenge.serasa.presentation.dao.SellerDAO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class SellerAdapter {

    public static SellerEntity toSellerEntity(Seller seller, StateRegionEntity stateRegion){
        SellerEntity entity = new SellerEntity();

        BeanUtils.copyProperties(seller, entity);
        entity.setStateRegion(stateRegion);

        return entity;
    }

    public static Seller toSeller(SellerEntity entity){
        Seller seller  = new Seller();

        BeanUtils.copyProperties(entity, seller);
        seller.setState(entity.getStateRegion().getState().getName());
        seller.setRegion(entity.getStateRegion().getRegion().getName());

        return seller;
    }

    public static  Seller toSeller(SellerDAO sellerDAO){
        Seller seller = new Seller();
        seller.setPhone(sellerDAO.getTelefone());
        seller.setCity(sellerDAO.getCidade());
        seller.setAge(sellerDAO.getIdade());
        seller.setRegion(sellerDAO.getRegiao());
        seller.setState(sellerDAO.getEstado());
        seller.setName(sellerDAO.getNome());

        return seller;
    }

    public static List<Seller> toSellerList(List<SellerEntity> entities){
        System.out.println(entities.toString());
        List<Seller> sellers = entities.stream().map(e -> {
            Seller seller = new Seller();
            BeanUtils.copyProperties(e, seller);
            seller.setState(e.getStateRegion().getState().getName());
            seller.setRegion(e.getStateRegion().getRegion().getName());
            return seller;
        }).collect(Collectors.toList());

        return sellers;
    }

    public static FindSellerByIdDAO toFindSellerByIdDAO(Seller seller, String[] states){
        FindSellerByIdDAO dao = new FindSellerByIdDAO();
        dao.setDataInclusao(seller.getCreatedAt());
        dao.setNome(seller.getName());
        dao.setEstados(states);

        return dao;
    }

    public static FindAllSellersDAO toFindAllSellersDAO(Seller seller, String[] states){
        FindAllSellersDAO dao = new FindAllSellersDAO();


        dao.setNome(seller.getName());
        dao.setTelefone(seller.getPhone());
        dao.setRegiao(seller.getRegion());
        dao.setIdade(seller.getAge());
        dao.setCidade(seller.getCity());
        dao.setEstado(seller.getState());
        dao.setDataInclusao(seller.getCreatedAt());
        dao.setEstados(states);

        return dao;
    }

}
