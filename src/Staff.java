public class Staff extends Item {

    public Staff(String type) {
        super(2, "Healing Staff",4,0,2,0);
        setAbility("Recover: Cast a spell to heal yourself for 8 hp. (Costs 2 stamina)");
        if (type.equals("Combat")) {
            setName("Combat Staff");
            setHealthBoost(0);
            setShieldBoost(0);
            setAttackBoost(8);
            setPlyBoost(2);
            setAbility("Whack: Lightly smack a targeted enemy, dealing damage equal to 50% of your attack. (Costs 2 stamina)");
        }
        setType(type);
    }

    public void useAbility(Enemy e, Player p) {
        if (getType().equals("Healing")) {
            int temp = p.getHealth();
            p.setHealth(p.getHealth() + 8);
            if (p.getHealth() > p.getMaxHealth()) {
                p.setHealth(p.getMaxHealth());
            }
            p.setPly(p.getPly() - 2);
            System.out.println(p.getName() + " used Recover and gained " + (p.getHealth() - temp) + " health!");
        } else if (getType().equals("Combat")) {
            int temp = e.getHealth();
            e.calculateDMG(p, 0.5);
            p.setPly(p.getPly() - 2);
            System.out.println(p.getName() + " used Whack on the " + e.getName() + ". The " + e.getName() + " took " + (temp - e.getHealth()) + " damage!");
        }
    }
}
