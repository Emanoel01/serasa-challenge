package com.challenge.serasa.infra.interfaces;

import com.challenge.serasa.infra.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInterface extends JpaRepository<SellerEntity, Integer> {
}
