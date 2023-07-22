package taller3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Menu {
	private Map<String, Integer> items;

    public Menu() {
        items = new HashMap<String, Integer>();
        items.put("Hamburguesa doble", 5);
        items.put("Hamburguesa simple", 3);
        items.put("Hamburguesa con queso", 4);
        items.put("Hamburguesa con queso y huevo", 7);
        items.put("Hamburguesa Especial", 10);
    }

    public void showMenu() {
        System.out.println("---------- Menú --------------");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("------------------------------");
        System.out.println("------------------------------ \n");
    }

    public boolean isValidItem(String item) {
        return items.containsKey(item);
    }

    public int getPrice(String item) {
        return items.getOrDefault(item, 0);
    }
}
