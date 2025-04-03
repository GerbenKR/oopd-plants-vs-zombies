package oopd.pvz.entities.inventory;

public class InventoryItem {
    private final int cost;
    private final int id;
    private final String name;

    public InventoryItem(int cost, int id, String name) {
        this.cost = cost;
        this.id = id;
        this.name = name;
    }

    public int getCost() {
        return cost;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
