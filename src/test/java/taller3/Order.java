package taller3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Order {
    private Menu menu;
    public Map<String, Integer> orderItems;

    public Order(Menu menu) {
        this.menu = menu;
        orderItems = new HashMap<String, Integer>();
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese el nombre de la comida que desea pedir (escriba 'salir' para finalizar): ");
            String item = scanner.nextLine().trim();

            if (item.equalsIgnoreCase("salir")) {
                break;
            }

            if (menu.isValidItem(item)) {
                System.out.print("Ingrese la cantidad de " + item + ": ");
                String quantityStr = scanner.nextLine().trim();
                int quantity = validateQuantity(quantityStr);

                if (quantity > 0) {
                    orderItems.put(item, quantity);
                } else {
                    System.out.println("Cantidad no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Comida no disponible en el menú. Intente nuevamente.");
            }
        }
    }

    private int validateQuantity(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity > 0) {
                return quantity;
            }
        } catch (NumberFormatException e) {
            // Do nothing, let it return 0
        }
        return 0;
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = menu.getPrice(item);
            totalCost += quantity * price;
        }

        if (orderItems.size() > 5) {
            totalCost *= 0.9;
        }

        if (orderItems.size() > 10) {
            totalCost *= 0.8;
        }

        if (totalCost > 50) {
            totalCost -= 10;
        }

        if (totalCost > 100) {
            totalCost -= 25;
        }

        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String item = entry.getKey();
            if (item.contains("Hamburguesa Especial")) {
                totalCost *= 1.05;
            }
        }

        return totalCost;
    }

    public void showOrderSummary() {
        System.out.println("----- Resumen del Pedido -----");
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + item);
        }
        System.out.println("Coste Total: $" + getTotalCost());
    }
}
