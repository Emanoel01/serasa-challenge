package com.challenge.serasa.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_state_region")
@Data
@NoArgsConstructor
public class StateRegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne()
    private StateEntity state;


    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne()
    private RegionEntity region;

    public StateRegionEntity (RegionEntity regionEntity, StateEntity stateEntity){
        this.state = stateEntity;
        this.region = regionEntity;
    }

}
