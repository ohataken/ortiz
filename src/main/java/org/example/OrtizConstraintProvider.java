package org.example;

import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.sum;

public class OrtizConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                penalizeKnapsackCapacityOver(constraintFactory),
                rewardKnapsackValue(constraintFactory),
        };
    }

    Constraint penalizeKnapsackCapacityOver(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Item.class)
                .filter((item) -> item.belongsToKnapsack())
                .groupBy(Item::getKnapsack, sum(Item::getWeight))
                .penalize(HardSoftScore.ONE_HARD, (knapsack, weight) -> knapsack.getCapacity() < weight ? weight - knapsack.getCapacity() : 0)
                .asConstraint("penalize knapsack capacity over");
    }

    Constraint rewardKnapsackValue(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Item.class)
                .filter((item) -> item.belongsToKnapsack())
                .groupBy(Item::getKnapsack, sum(Item::getValue))
                .reward(HardSoftScore.ONE_SOFT, (knapsack, value) -> value)
                .asConstraint("reward knapsack value");
    }

}
