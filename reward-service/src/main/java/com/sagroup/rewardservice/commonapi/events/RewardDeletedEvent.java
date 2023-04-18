package com.sagroup.rewardservice.commonapi.events;

public class RewardDeletedEvent extends BaseEvent<String> {
    public RewardDeletedEvent(String id) {
        super(id);
    }
}