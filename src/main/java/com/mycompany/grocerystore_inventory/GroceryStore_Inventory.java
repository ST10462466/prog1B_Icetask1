package com.mycompany.grocerystore_inventory;
import java.util.Scanner;
import java.util.ArrayList;

public class GroceryStore_Inventory {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // initial array of 5 items 
        Item[] initialItems = {
            new Item("Orange", Category.FRUITS, 11.95),
            new Item("Green pepper", Category.VEGETABLES, 9.99),
            new Item("Cheese", Category.DAIRY, 25.00),
            new Item("Croissant", Category.BAKERY, 18.99),
            new Item("Beef", Category.MEAT, 75.50)
        
        };
        
        // arraylist for the dynamic inventory
        ArrayList<Item> inventory = new ArrayList<>();
        
        // Add the array items to the arrayList
        for (Item item : initialItems) {
            inventory.add(item);
        }
        
        int choice;
        
        do{
            System.out.println("\n===== GROCERY INVENTORY =====");
            System.out.println("1. Display all items");
            System.out.println("2. Add a new item");
            System.out.println("3. Remove an item");
            System.out.println("4. Display items by category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {

                case 1 -> displayAllItems(inventory);

                case 2 -> addItem(inventory, input);

                case 3 -> removeItem(inventory, input);

                case 4 -> displayByCategory(inventory, input);

                case 5 -> System.out.println("Goodbye!");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
        
        
        
       
        
        
        
        
        
        
    }
}
