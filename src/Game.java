import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Welcome to the Epic RPG! Please type insert your name below:");
        String n = user.nextLine();
        System.out.println("Hello " + n + "! Now please type the corresponding number to choose a class!");
        System.out.println("1: Knight - Normal, balanced stats.");
        System.out.println("2: Archer - Low shield but high energy.");
        System.out.println("3: Warrior - Low attack and low energy, but High HP and high shield.");
        //System.out.println("4: Paladin - Normal HP and very low energy, but high attack and very high shield.");
        //System.out.println("5: Assassin - Low HP and low shield, but high attack and very high energy.");

        int kitChoice = user.nextInt();

        int health = 30;
        int attack = 10;
        int shield = 20;
        int ply = 12;
        String kit = "Error";

        if (kitChoice == 1) {
            kit = "Knight";
        } else if (kitChoice == 2) {
            health = 35;
            attack = 8;
            shield = 10;
            ply = 16;
            kit = "Archer";
        } else if (kitChoice == 3) {
            health = 60;
            attack = 6;
            shield = 40;
            ply = 8;
            kit = "Warrior";
        }

        // else if (kitChoice == 4) {
            //health = 35;
            //attack = 14;
            //shield = 60;
            //ply = 4;
            //kit = "Paladin";
        //} else if (kitChoice == 5) {
            //health = 20;
            //attack = 20;
            //shield = 10;
            //ply = 16;
            //kit = "Assassin";
        //}

        Player player = new Player(health, shield, attack, n, kit, ply);
        System.out.println(player.line() + "\nWelcome " + n + " the " + player.getKit() + "! Are you ready to start your adventure?\n");

        String ready = user.next();

        if (!ready.isEmpty()) {
            Slime slime = new Slime("Blue");
            Goblin goblin = new Goblin();
            ArrayList<Enemy> encounter1 = new ArrayList<Enemy>();
            encounter1.add(slime);
            encounter1.add(goblin);
            encounter1.add(new Slime("Pink"));
            encounter1.add(new Goblin("Archer"));
            Encounter e1 = new Encounter(encounter1);
            e1.intro(player);
            e1.enemyList(player, false);
            while (player.getHealth() > 0 && e1.enemiesAlive()) {
                while (player.getPly() != -1) {
                    e1.decision(player);
                    int option = user.nextInt();
                    e1.choice1(option, player);
                }
                e1.enemiesAttack(player);
                player.setPly(player.getMaxPly());
            }
        }
    }
}
