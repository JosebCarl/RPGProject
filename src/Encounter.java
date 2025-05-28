import java.util.ArrayList;
import java.util.Scanner;

public class Encounter {
    private ArrayList<Enemy> enemies;

    public Encounter(ArrayList<Enemy> e) {
        enemies = e;
    }

    //Intro for the beginning of an encounter

    public void intro(Player p) {
        System.out.println(p.line());
        System.out.print("A wild " + enemies.getFirst().getName());
        if (enemies.size() == 2) {
            System.out.print(" and " + enemies.get(1).getName());
        } else if (enemies.size() > 2) {
            for (int i = 1; i < enemies.size() - 1; i++) {
                System.out.print(", " + enemies.get(i).getName());
            }
            System.out.print(", and " + enemies.getLast().getName());
        }
        System.out.println(" appeared!\nWhat do you do?");
    }

    //Checks if all enemies in the encounter are alive

    public boolean enemiesAlive() {
        boolean result = false;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).isAlive()) {
                result = true;
            }
        }
        return result;
    }

    //Makes the enemies attack the player during their turn

    public void enemiesAttack(Player p) {
        System.out.print(p.space() + p.line());
        System.out.println("\nYour turn has ended.");
        int temp = p.getShield();
        if (p.isDefend()) {
            p.setShield((int) (p.getShield() * 2.5));
            if (p.getShield() >= 80) {
                p.setShield(80);
            }
            System.out.println("Your defense has been increased to " + p.getShield() + " for this turn.");
        }
        for (Enemy enemy : enemies) {
            enemy.calculateAttack(p);
            if (enemy.specialTrue()) {
                enemy.useSpecialText();
            }
        }
        p.setDefend(false);
        p.setShield(temp);
        System.out.print(p.line());
        enemyList(p, false);
        if (p.getHealth() == 0) {
            System.out.println("\nGame over! You lost all of your health!\nBetter luck next time " + p.getName() + "...");
        }
    }

    //Prints the current enemies and their stats

    public void enemyList(Player p, boolean space) {
        if (space) {
            System.out.print(p.space() + p.line());
        }
        for (Enemy e : enemies) {
            if (e.isAlive()){
                System.out.println("\n" + e);
            }
        }
    }

    //Prints the decision text for the player

    public void decision(Player p) {
        System.out.println(p.line() + "\n1) Attack (3 stamina)\n2) Heavy Attack (5 stamina)\n3) Item\n4) Defend (4 stamina) (ends turn)\n5) End Turn\n");
        System.out.println(p);
    }

    //Code for what each choice in "decision" does.

    public void choice1(int option, Player p) {
        Scanner choice = new Scanner(System.in);
        if (option == 1 || option == 2) { //Attacking
            int temp;
            if (option == 1) {
                temp = 3;
            } else {
                temp = 5;
            }
            enemyList(p, true);
            if (p.checkPly(temp)) {
                System.out.println(p.line() + "\nWhich enemy would you like to attack?\n0) Back");
                for (int i = 0; i < enemies.size(); i++) {
                    System.out.println((i + 1) + ") " + enemies.get(i).getName());
                }
                int next = choice.nextInt();
                if (next > 0 && next < enemies.size() + 1) {
                    int before = enemies.get(next - 1).getHealth();
                    System.out.println(p.line());
                    enemies.get(next - 1).calculateDMG(p, option);
                    enemyList(p,true);
                    System.out.println(p.line());
                    if (enemies.get(next - 1).specialTrue()) {
                        enemies.get(next - 1).useSpecialText();
                    }
                    int dealt = before - enemies.get(next - 1).getHealth();
                    System.out.println("The " + enemies.get(next - 1).getName() + " took " + dealt + " damage!");
                    p.setPly(p.getPly() - temp);
                } else if (next == 0) {
                    enemyList(p, true);
                }
            } else {
                enemyList(p, true);
                System.out.println(p.line());
                System.out.println("You don't have enough stamina!");
            }
        } else if (option == 3) { //Item
            if (!p.getItemList().isEmpty()) {
                enemyList(p, true);
                System.out.println(p.line() + "\nWhich item would you like to use?\n0) Back");
                for (int item = 0; item < p.getItemList().size(); item++) {
                    System.out.println((item + 1) + ") " + p.getItemList().get(item).getAbility());
                }
                int next = choice.nextInt();
                if (next > 0 && next < p.getItemList().size() + 1) {
                    if (p.checkPly(p.getItemList().get(next - 1).getCost())) {
                        if (p.getItemList().get(next - 1).getName().equals("Combat Staff")) {
                            System.out.println(p.line() + "\nWhich enemy would you like to target?\n0) Back");
                            for (int i = 0; i < enemies.size(); i++) {
                                System.out.println((i + 1) + ") " + enemies.get(i).getName());
                            }
                            int next2 = choice.nextInt();
                            if (next2 > 0 && next < enemies.size() + 1) {
                                System.out.println(p.space() + p.line());
                                if (enemies.get(next2 - 1).specialTrue()) {
                                    enemies.get(next2 - 1).useSpecialText();
                                }
                                p.getItemList().get(next - 1).useAbility(enemies.get(next2 - 1), p);
                                System.out.println(p.line());
                                enemyList(p,false);
                            }
                        } else {
                            enemyList(p,true);
                            p.getItemList().get(next - 1).useAbility(enemies.getFirst(), p);
                        }

                    } else {
                        enemyList(p,true);
                        System.out.println(p.line());
                        System.out.println("You don't have enough stamina!");
                    }

                }
            } else {
                System.out.println("You do not have any items at the current moment.");
            }
        } else if (option == 4) { //Defend
            if (p.checkPly(4)) {
                p.setDefend(true);
                p.setPly(-1);
            } else {
                enemyList(p,true);
                System.out.println(p.line());
                System.out.println("You don't have enough stamina!");
            }
        } else if (option == 5) {
            p.setPly(-1);
        }
    }
}
