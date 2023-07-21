package taller3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		    Menu menu = new Menu();
	        menu.showMenu();

	        Order order = new Order(menu);
	        order.takeOrder();

	        if (order.getTotalCost() <= 0) {
	            System.out.println("Pedido cancelado. No se ha seleccionado ninguna comida.");
	        } else {
	            order.showOrderSummary();
	        }
	    

	}

}
