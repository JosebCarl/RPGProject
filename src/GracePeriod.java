import java.util.ArrayList;
import java.util.Scanner;

public class GracePeriod {
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public GracePeriod(ArrayList<Item> a) {
        ArrayList<Item> choices = new ArrayList<Item>();
        while (choices.size() != 2) {
            int random = (int) (Math.random() * a.size());
            if (!a.get(random).getIsBrought()) {
                choices.add(a.get(random));
            }
        }
        items = choices;
    }

    public void itemList(Player p) {
        int c = 1;
        System.out.print(p.space() + p.line());
        for (Item i : items) {
                System.out.println("\n" + c + ") " + i);
                c++;
        }
        System.out.println(p.line() + "\n Choose an item to keep.");
    }

    public void choice2(int option, Player p) {
        if (option == 1 || option == 2) {
            p.addItem(items.get(option - 1));
            items.get(option - 1).setIsBrought(true);
            System.out.println(p.line() + "\nYou took the " + p.getItemList().getLast().getName() + "!");
        }
    }
}
