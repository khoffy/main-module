package com.sagroup.rewardservice.queries.controllers;

import com.sagroup.rewardservice.commonapi.queries.GetAllRewardsQuery;
import com.sagroup.rewardservice.commonapi.queries.GetRewardByIdQuery;
import com.sagroup.rewardservice.queries.entities.Reward;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/rewards")
public class RewardQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/allRewards")
    public List<Reward> rewardList() {
        // To use QueryGateway, we need to create an object query
        // that will be created inside "queries" package in commonApi
        List<Reward> response = queryGateway
                .query(new GetAllRewardsQuery(), ResponseTypes.multipleInstancesOf(Reward.class))
                .join();
        return response;
    }

    @GetMapping("/byId/{rewardId}")
    public Reward getReward(@PathVariable String rewardId) {
        // To use QueryGateway, we need to create an object query
        // that will be created inside "queries" package in commonApi
        Reward response = queryGateway
                .query(new GetRewardByIdQuery(rewardId), ResponseTypes.instanceOf(Reward.class))
                .join();
        return response;
    }

    @Autowired
    public void setQueryGateway(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
}