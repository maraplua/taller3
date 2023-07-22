package taller3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuOrderTest {
    private Menu menu;

 
    @Test
    void testGetPrice_ValidItem_ReturnsCorrectPrice() {
        int price = menu.getPrice("Hamburguesa doble");
        assertEquals(5, price);
    }

    @Test
    void testGetPrice_InvalidItem_ReturnsDefaultPrice() {
        int price = menu.getPrice("Papas fritas"); // This item does not exist in the menu
        assertEquals(0, price); // The default price for an invalid item is 0
    }

    @Test
    void testIsValidItem_ValidItem_ReturnsTrue() {
        assertTrue(menu.isValidItem("Hamburguesa simple"));
    }

    @Test
    void testIsValidItem_InvalidItem_ReturnsFalse() {
        assertFalse(menu.isValidItem("Ensalada")); // This item does not exist in the menu
    }

    @Test
    void testGetTotalCost_NoOrderItems_ReturnsZero() {
        Order order = new Order(menu);
        int totalCost = order.getTotalCost();
        assertEquals(0, totalCost);
    }

    @Test
    void testGetTotalCost_WithOrderItems_ReturnsCorrectTotalCost() {
        Order order = new Order(menu);

        // Simulate user input for order items
        order.orderItems.put("Hamburguesa doble", 2);
        order.orderItems.put("Hamburguesa con queso", 1);

        int totalCost = order.getTotalCost();
        assertEquals(17, totalCost); // 2 * $5 (Hamburguesa doble) + 1 * $4 (Hamburguesa con queso)
    }

    @Test
    void testGetTotalCost_WithDiscounts_ReturnsCorrectTotalCost() {
        Order order = new Order(menu);

        // Simulate user input for order items
        order.orderItems.put("Hamburguesa doble", 6);
        order.orderItems.put("Hamburguesa con queso", 5);
        order.orderItems.put("Hamburguesa Especial", 3);

        int totalCost = order.getTotalCost();
        // Total cost after discounts: (6 * $5 + 5 * $4 + 3 * $10) * 0.9 * 0.8 * 1.05 - $10 - $25
        assertEquals(92, totalCost);
    }
}
