package org.example;

public class Item {

    private Integer id;
    private Integer value;
    private Integer weight;
    private Knapsack knapsack;

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