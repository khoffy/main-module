package com.sagroup.rewardservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDto {
    private String rewardId;
    private String name;
    private int quantity;
    private String rewardType;

    private int price;
}