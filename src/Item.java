public class Item {
    private int cost;
    private int healthBoost;
    private int shieldBoost;
    private int attackBoost;
    private int plyBoost;
    private String name;
    private String ability;
    private String type;
    private Boolean isBrought;

    public Item(int cost, String name, int h, int s, int a, int p) {
        this.cost = cost;
        this.name = name;
        this.isBrought = false;
        healthBoost = h;
        shieldBoost = s;
        attackBoost = a;
        plyBoost = p;
        ability = "No special abilities";
        type = "None";
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public int getShieldBoost() {
        return shieldBoost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public int getPlyBoost() {
        return plyBoost;
    }

    public String getAbility() {
        return ability;
    }

    public String getType() {
        return type;
    }

    public Boolean getIsBrought() {
        return isBrought;
    }

    public void setAbility(String a) {
        ability = a;
    }

    public void setCost(int c) {
        cost = c;
    }

    public void setName(String n) {
        name = n;
    }

    public void setHealthBoost(int s) {
        healthBoost = s;
    }

    public void setShieldBoost(int s) {
        shieldBoost = s;
    }

    public void setAttackBoost(int s) {
        attackBoost = s;
    }

    public void setPlyBoost(int s) {
        plyBoost = s;
    }

    public void setType(String s) {
        type = s;
    }

    public void setIsBrought(boolean s) {
        isBrought = s;
    }

    public String toString() {
        String print = name;
        if (healthBoost != 0) {
            print += "\n+" + healthBoost + " health";
        }
        if (shieldBoost != 0) {
            print += "\n+" + shieldBoost + " shield";
        }
        if (attackBoost != 0) {
            print += "\n+" + attackBoost + " attack";
        }
        if (plyBoost != 0) {
            print += "\n+" + plyBoost + " stamina";
        }
        print += "\n" + ability;
        return print;
    }

    public void applyBoosts(Player p) {
        p.setMaxHealth(p.getMaxHealth() + healthBoost);
        p.setShield(p.getShield() + shieldBoost);
        p.setAttack(p.getAttack() + attackBoost);
        p.setMaxPly(p.getPly() + plyBoost);
    }

    public void useAbility(Enemy e, Player p) {}
}
