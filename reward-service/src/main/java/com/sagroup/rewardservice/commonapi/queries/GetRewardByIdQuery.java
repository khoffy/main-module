package com.sagroup.rewardservice.commonapi.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRewardByIdQuery {
    private String rewardId;
}
