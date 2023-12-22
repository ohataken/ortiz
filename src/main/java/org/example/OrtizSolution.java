package org.example;

import java.util.List;
import java.util.ArrayList;

public class OrtizSolution {

    private List<Knapsack> knapsacks;

    private List<Item> items;

    public OrtizSolution() {
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

}
