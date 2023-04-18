package com.sagroup.rewardservice.commands.controllers;

import com.sagroup.rewardservice.commonapi.commands.CreateRewardCommand;
import com.sagroup.rewardservice.commonapi.commands.DeleteRewardCommand;
import com.sagroup.rewardservice.commonapi.commands.UpdateRewardCommand;
import com.sagroup.rewardservice.commonapi.dtos.RewardDto;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping(path = "/commands/rewards")
public class RewardCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createReward(@RequestBody RewardDto rewardDto) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRewardCommand(
                        UUID.randomUUID().toString(),
                        rewardDto.getName(),
                        rewardDto.getQuantity(),
                        rewardDto.getRewardType().toString(),
                        rewardDto.getPrice()
                )
        );
        return commandResponse;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateReward(@RequestBody RewardDto rewardDto) {
        log.info("***************************************************");
        log.info("Update method from RewardCommandController");
        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateRewardCommand(
                rewardDto.getRewardId(),
                rewardDto.getName(),
                rewardDto.getQuantity(),
                rewardDto.getRewardType().toString(),
                rewardDto.getPrice()
        ));
        return commandResponse;
    }

    @DeleteMapping("/{rewardId}")
    public CompletableFuture<String> deleteReward(@PathVariable String rewardId) {
        log.info("***************************************************");
        log.info("Delete method from RewardCommandController");
        CompletableFuture<String> commandResponse = commandGateway.send(new DeleteRewardCommand(
                rewardId
        ));
        return commandResponse;
    }

    @GetMapping("/eventStore/{rewardId}")
    public Stream eventStore(@PathVariable String rewardId) {
        return eventStore.readEvents(rewardId).asStream();
    }

    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    public void setEventStore(EventStore eventStore) {
        this.eventStore = eventStore;
    }
}