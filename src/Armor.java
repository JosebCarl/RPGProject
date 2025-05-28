public class Armor extends Item {

    public Armor(String type) {
        super(0,"Leather Boots", 12,5,0, 4);
        setType("Boots");
        if (type.equals("ChestPlate")) {
            setName("Chainmail ChestPlate");
            setHealthBoost(30);
            setShieldBoost(10);
            setPlyBoost(0);
            setType(type);
        } else if (type.equals("Helmet")) {
            setName("SpikeRock Helmet");
            setHealthBoost(8);
            setAttackBoost(4);
            setPlyBoost(1);
            setAbility("Brace: Any enemy that attacks you during their turn will take 8 guaranteed damage. (Costs 4 stamina)");
            setType(type);
        }
    }

    public void useAbility(Enemy e, Player p) {
        p.setIsBrace(true);
        System.out.println(p.getName() + " is bracing for impact!");
        p.setPly(p.getPly() - 4);
    }
}
