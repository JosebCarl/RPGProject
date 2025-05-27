public class Goblin extends Enemy {

    public Goblin() {
        super(20,15,8,"Goblin");
        this.setPassiveWhenAttacks(1);
    }

    public Goblin (String type) {
        super(20,15,8,"Goblin");
        if (type.equals("Archer")) {
            this.setName("Archer Goblin");
            this.setHealth(15);
            this.setMaxHealth(15);
            this.setAttack(12);
            this.setPassiveWhenAttacked(1);
        } else {
            this.setPassiveWhenAttacks(1);
        }
    }

    public void calculateDMG(Player p, int option) {
        if (this.getPassiveWhenAttacked() == 1) {
            int chance = (int) (Math.random() * 2) + 1;
            if (chance == 1) {
                super.calculateDMG(p, option);
            } else if (chance == 2) {
                setSpecial(true);
            }
        } else {
            super.calculateDMG(p, option);
        }
    }

    public void calculateAttack(Player p) {
        if (isAlive()){
            if (this.getPassiveWhenAttacks() == 1) {
                int chance = (int) (Math.random() * 2) + 1;
                if (chance == 1) {
                    super.calculateAttack(p);
                } else if (chance == 2) {
                    this.setAttack(this.getAttack() * 2);
                    setSpecial(true);
                }
            } else {
                super.calculateAttack(p);
            }
        }
    }

    public String toString() {
        String special = "";
        if (this.getPassiveWhenAttacked() == 1) {
            special = "\nAbility: Quick Feet - When this enemy is attacked, there is a 50% chance it will dodge it.";
        } else if (this.getPassiveWhenAttacks() == 1) {
            special = "\nAbility: Bulk-Up - Instead of attacking, this enemy has a chance of doubling their attack.";
        }
        return super.toString() + special;
    }

    public void useSpecialText() {
        if (getPassiveWhenAttacks() == 1) {
            System.out.println("The Goblin used Bulk-Up! It's attack has been doubled!");
            setSpecial(false);
        } else if (getPassiveWhenAttacked() == 1) {
            System.out.println("The Goblin dodged the Attack!");
            setSpecial(false);
        }
    }
}
