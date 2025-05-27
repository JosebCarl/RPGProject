public class Item {
    private int cost;
    private int stats;
    private String name;
    private Boolean isBrought;

    public Item(int cost, int stats, String name) {
        this.cost = cost;
        this.stats = stats;
        this.name = name;
        this.isBrought = false;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsBrought() {
        return isBrought;
    }

    public int getStats() {
        return stats;
    }
}
