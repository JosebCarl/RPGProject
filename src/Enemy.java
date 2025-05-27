public class Enemy {
    private int maxHealth;
    private int health;
    private int shield;
    private int attack;
    private int passiveWhenAttacked;
    private int passiveWhenAttacks;
    private String name;
    private boolean alive;
    private boolean special = false;

    public Enemy () {}

    public Enemy(int hp, int shld, int dmg, String name) {
        maxHealth = hp;
        health = hp;
        shield = shld;
        attack = dmg;
        this.name = name;
        alive = true;
        passiveWhenAttacked = 0;
        passiveWhenAttacks = 0;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        if (this.isAlive()) {
            return name;
        } else {
            return name + " (DEAD)";
        }
    }

    public int getPassiveWhenAttacked() {
        return passiveWhenAttacked;
    }

    public int getPassiveWhenAttacks() {
        return passiveWhenAttacks;
    }

    public boolean specialTrue() {
        return special;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setHealth(int hp) {
        health = hp;
    }

    public void setMaxHealth(int hp) {
        maxHealth = hp;
    }

    public void setShield(int shld) {
        if (shld >= 40) {
            shield = 40;
        }
        shield = shld;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAttack(int atk) {
        attack = atk;
    }

    public void setPassiveWhenAttacked(int p) {
        passiveWhenAttacked = p;
    }

    public void setPassiveWhenAttacks(int p) {
        passiveWhenAttacks = p;
    }

    public void setSpecial(boolean d) {
        special = d;
    }

    //Calculates the incoming damage

    public void calculateDMG(Player p, int option) {
        double reduction = (this.shield * 0.01);
        this.setHealth(this.health - (int) (p.getAttack() * option * (1 - reduction)));
        if (this.health <= 0) {
            alive = false;
            health = 0;
        }
    }

    //Calculates the damage the enemy deals to the player

    public void calculateAttack(Player p) {
        if (isAlive()) {
            int temp = p.getHealth();
            double reduction = (p.getShield() * 0.01);
            p.setHealth(p.getHealth() - (int) (this.getAttack() * (1 - reduction)));
            System.out.println("The " + name + " dealt " + (temp - p.getHealth()) + " damage!");
            if (p.getHealth() <= 0) {
                p.setHealth(0);
            }
        }
    }

    // Placeholder for enemies with special abilities

    public void useSpecialText() {}

    public String toString() {
        return name + "'s stat's: " + "\nHP: " + health + "/" + maxHealth + "\nAttack: " + attack + " || Shield: " + shield;
    }
}
