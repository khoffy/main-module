package com.sagroup.rewardservice.commonapi.commands;

import lombok.Getter;

public class UpdateRewardCommand extends BaseCommand<String> {

    @Getter
    private String name;

    @Getter
    private int quantity;

    @Getter
    private String rewardType;
    @Getter
    private int price;
    public UpdateRewardCommand(String id, String name, int quantity, String rewardType, int price) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.rewardType = rewardType;
        this.price = price;
    }
}