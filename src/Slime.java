public class Slime extends Enemy {

    public Slime() {
        super(12, 0, 4, "Green Slime");
    }

    public Slime (String c) {
        super(12, 0, 4, "Green Slime");
        if (c.equals("Blue")) {
            this.setName("Blue Slime");
            this.setShield(50);
        } else if (c.equals("Pink")) {
            this.setName("Pink Slime");
            this.setHealth(20);
            this.setAttack(16);
        }
    }
}
