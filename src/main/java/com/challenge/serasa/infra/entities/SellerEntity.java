package com.challenge.serasa.infra.entities;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_seller")
@Data
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private Integer age;

    @Column
    private String city;

    @ManyToOne()
    @JoinColumn(name = "state_region_id", referencedColumnName = "id")
    private StateRegionEntity stateRegion;

    @Column(name = "created_at")
    @CreatedDate
    @CreationTimestamp
    private Date createdAt;


}
