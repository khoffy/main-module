package com.sagroup.rewardservice.queries.entities;
import com.sagroup.rewardservice.commonapi.enums.RewardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
//@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Reward {

    @Id
    private String rewardId;

    private String name;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private RewardType rewardType;

    private Integer price;

}