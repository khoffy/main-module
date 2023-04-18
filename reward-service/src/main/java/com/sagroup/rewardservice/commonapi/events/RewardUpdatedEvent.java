package com.sagroup.rewardservice.commonapi.events;

import lombok.Getter;

public class RewardUpdatedEvent extends BaseEvent<String> {
    @Getter
    private String name;

    @Getter
    private int quantity;

    @Getter
    private String rewardType;

    @Getter
    private int price;

    public RewardUpdatedEvent(String id,  String name, int quantity, String rewardType, int price) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.rewardType = rewardType;
        this.price = price;
    }
}