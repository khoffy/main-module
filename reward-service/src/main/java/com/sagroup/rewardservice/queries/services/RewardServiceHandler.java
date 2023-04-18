package com.sagroup.rewardservice.queries.services;

import com.sagroup.rewardservice.commonapi.enums.RewardType;
import com.sagroup.rewardservice.commonapi.events.RewardCreatedEvent;
import com.sagroup.rewardservice.commonapi.events.RewardDeletedEvent;
import com.sagroup.rewardservice.commonapi.events.RewardUpdatedEvent;
import com.sagroup.rewardservice.commonapi.queries.GetAllRewardsQuery;
import com.sagroup.rewardservice.commonapi.queries.GetRewardByIdQuery;
import com.sagroup.rewardservice.queries.entities.Reward;
import com.sagroup.rewardservice.queries.repositories.RewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class RewardServiceHandler {
    public RewardRepository rewardRepository;

    @EventHandler
    public void on(RewardCreatedEvent event) {
        log.info("*************************************");
        log.info("RewardCreatedEvent received in RewardServiceHandler");
        Reward reward = new Reward();
        reward.setRewardId(event.getId());
        reward.setName(event.getName());
        reward.setQuantity(event.getQuantity());
        reward.setPrice(event.getPrice());
        assignRewardType(event.getRewardType(), reward);
        rewardRepository.save(reward);
    }

    @EventHandler
    public void on(RewardUpdatedEvent event) {
        log.info("*************************************");
        log.info("RewardUpdatedEvent received in RewardServiceHandler");
        Reward reward = rewardRepository.findById(event.getId()).get();
        reward.setName(event.getName());
        reward.setQuantity(event.getQuantity());
        reward.setPrice(event.getPrice());
        assignRewardType(event.getRewardType(), reward);
        rewardRepository.save(reward);
    }

    @EventHandler
    public void on(RewardDeletedEvent rewardDeletedEvent) {
        rewardRepository.deleteById(rewardDeletedEvent.getId());
    }

    @QueryHandler
    List<Reward> on(GetAllRewardsQuery query) {return rewardRepository.findAll();}


    @QueryHandler
    Reward on(GetRewardByIdQuery query) {return rewardRepository.findById(query.getRewardId()).get();}

    private void assignRewardType(String rewardType, Reward reward) {
        switch (rewardType) {
            case "IN_SCHOOL":
                reward.setRewardType(RewardType.IN_SCHOOL);
                break;
            case "GIFT":
                reward.setRewardType(RewardType.GIFT);
                break;
            case "ELEMENT":
            default:
                reward.setRewardType(RewardType.ELEMENT);
        }
    }

    @Autowired
    public void setRewardRepository(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }
}
