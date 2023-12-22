package org.example;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.Objects;

@PlanningEntity
public class Item {

    @PlanningId
    private Integer id;
    private Integer value;
    private Integer weight;
    @PlanningVariable(valueRangeProviderRefs = { "knapsackRange" }, nullable = true)
    private Knapsack knapsack;

    Item() {
    }

    Item(Integer id, Integer value, Integer weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public boolean belongsToKnapsack() {
        return Objects.nonNull(this.knapsack);
    }

    public Knapsack getKnapsack() {
        return this.knapsack;
    }

    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

}