package com.mycompany.grocerystore_inventory;
import java.util.Scanner;
import java.util.ArrayList;

public class GroceryStore_Inventory {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Item[] initialItems = {
            new Item("Orange", Category.FRUITS, 11.95),
            new Item("Green pepper", Category.VEGETABLES, 9.99),
            new Item("Cheese", Category.DAIRY, 25.00),
            new Item("Croissant", Category.BAKERY, 18.99),
            new Item("Beef", Category.MEAT, 75.50)
        
        };
   }
}
