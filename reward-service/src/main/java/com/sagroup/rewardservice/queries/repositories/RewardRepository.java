package com.sagroup.rewardservice.queries.repositories;

import com.sagroup.rewardservice.queries.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface RewardRepository extends MongoRepository<Reward, String> {
//}
public interface RewardRepository extends JpaRepository<Reward, String> {
}
