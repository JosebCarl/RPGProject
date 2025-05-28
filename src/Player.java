import java.util.ArrayList;

public class Player {
    private int maxPly;
    private int ply;
    //Ply means turns in some games; idk i felt like using it ;-;
    private int health;
    private int maxHealth;
    private int shield;
    private int attack;
    private String name;
    private String kit;
    private boolean isDefend;
    private boolean isBrace;
    private ArrayList<Item> items;

    public Player(int hp, int shld, int dmg, String name, String kit, int p) {
        maxHealth = hp;
        health = hp;
        shield = shld;
        attack = dmg;
        this.name = name;
        this.kit = kit;
        maxPly = p;
        ply = p;
        items = new ArrayList<Item>();
        isBrace = false;
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
        return name;
    }

    public String getKit() {
        return kit;
    }

    public int getPly() {
        return ply;
    }

    public int getMaxPly() {
        return maxPly;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public ArrayList<Item> getItemList() {
        return items;
    }

    public boolean isDefend() {
        return isDefend;
    }

    public boolean isBrace() {
        return isBrace;
    }

    public void setHealth(int hp) {
        health = hp;
    }

    public void setMaxHealth(int hp) {
        maxHealth = hp;
    }

    public void setShield(int shld) {
        shield = shld;
    }

    public void setAttack(int atk) {
        attack = atk;
    }

    public void setPly(int p) {
        ply = p;
    }

    public void setMaxPly(int p) {
        maxPly = p;
    }

    public void setDefend(boolean d) {
        isDefend = d;
    }

    public void setIsBrace(boolean b) {
        isBrace = b;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public String toString() {
        return name + "'s stat's: " + "\nHP: " + health + "/" + maxHealth + "\nAttack: " + attack + " || Shield: " + shield + "\nStamina: " + ply + "/" + maxPly;
    }

    public String line() {
        return "-------------------------------------------------------";
    }

    public String space() {
        return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    }

    public boolean checkPly(int p) {
        return ply - p >= 0;
    }

    public void recover() {
        health = maxHealth;
        ply = maxPly;
    }
}