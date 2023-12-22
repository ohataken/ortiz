package org.example;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;
import java.util.ArrayList;

@PlanningSolution
public class OrtizSolution {

    @PlanningScore
    private HardSoftScore score;

    @ValueRangeProvider(id = "knapsackRange")
    private List<Knapsack> knapsacks;

    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "itemRange")
    private List<Item> items;

    public OrtizSolution() {
        this.score = HardSoftScore.ZERO;
        this.knapsacks = new ArrayList<Knapsack>();
        this.items = new ArrayList<Item>();
    }

    public List<Knapsack> getKnapsacks() {
        return this.knapsacks;
    }

    public void setKnapsacks(List<Knapsack> knapsacks) {
        this.knapsacks = knapsacks;
    }

    public boolean addKnapsack(Knapsack knapsack) {
        return this.knapsacks.add(knapsack);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    public HardSoftScore getScore() {
        return this.score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}
