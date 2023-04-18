package com.sagroup.rewardservice.commands.aggregates;

import com.sagroup.rewardservice.commonapi.commands.CreateRewardCommand;
import com.sagroup.rewardservice.commonapi.commands.DeleteRewardCommand;
import com.sagroup.rewardservice.commonapi.commands.UpdateRewardCommand;
import com.sagroup.rewardservice.commonapi.enums.RewardType;
import com.sagroup.rewardservice.commonapi.events.RewardCreatedEvent;
import com.sagroup.rewardservice.commonapi.events.RewardDeletedEvent;
import com.sagroup.rewardservice.commonapi.events.RewardUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Slf4j
@Aggregate
public class RewardAggregate {

    @AggregateIdentifier
    private String rewardId;

    private String name;
    private int quantity;

    private RewardType rewardType;
    private int price;

    public RewardAggregate () {
        // Default Constructor required by AXON
    }

    // -------------------------- Start Create Reward --------------------------
    /**
     * Treat the CreateRewardCommand, create and send RewardCreatedEvent
     * @param createRewardCommand
     */
    @CommandHandler
    public RewardAggregate (CreateRewardCommand createRewardCommand) {
        AggregateLifecycle.apply(
                new RewardCreatedEvent(
                        createRewardCommand.getId(),
                        createRewardCommand.getName(),
                        createRewardCommand.getQuantity(),
                        createRewardCommand.getRewardType(),
                        createRewardCommand.getPrice())
        );
    }

    /**
     * Treat RewardCreatedEvent sent by CreateRewardCommand handler
     * @param event
     */
    @EventSourcingHandler
    public void on(RewardCreatedEvent event) {
        this.rewardId = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        assignRewardType(event.getRewardType());
    }

    // -------------------------- End Create Reward --------------------------

    // -------------------------- Start Update Reward --------------------------
    @CommandHandler
    public RewardAggregate(UpdateRewardCommand updateRewardCommand) {
        log.info("***************************************************");
        log.info("UpdateRewardCommand CommandHandler from RewardAggregate");
        AggregateLifecycle.apply(
                new RewardUpdatedEvent(
                        updateRewardCommand.getId(),
                        updateRewardCommand.getName(),
                        updateRewardCommand.getQuantity(),
                        updateRewardCommand.getRewardType(),
                        updateRewardCommand.getPrice())
        );
    }

    @EventSourcingHandler
    public void on(RewardUpdatedEvent rewardUpdatedEvent) {
        log.info("***************************************************");
        log.info("RewardUpdatedEvent EventSourcingHandler from RewardAggregate");
        //this.rewardId = rewardUpdatedEvent.getId();
        this.name = rewardUpdatedEvent.getName();
        this.quantity = rewardUpdatedEvent.getQuantity();
        this.price = rewardUpdatedEvent.getPrice();
        assignRewardType(rewardUpdatedEvent.getRewardType());
    }

    // -------------------------- End Update Reward --------------------------
    // -------------------------- Start Delete Reward --------------------------
    @CommandHandler
    public RewardAggregate(DeleteRewardCommand deleteRewardCommand) {
        log.info("***************************************************");
        log.info("UpdateRewardCommand CommandHandler from RewardAggregate");
        AggregateLifecycle.apply(new RewardDeletedEvent(
                deleteRewardCommand.getId()
        ));
    }
    private void assignRewardType(String rewardType) {
        switch (rewardType) {
            case "ELEMENT":
                this.rewardType = RewardType.ELEMENT;
                break;
            case "IN_SCHOOL":
                this.rewardType = RewardType.IN_SCHOOL;
                break;
            case "GIFT":
                this.rewardType = RewardType.GIFT;
                break;
            default:
        }
    }

}
