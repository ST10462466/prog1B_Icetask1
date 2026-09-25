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
        
        // Display all items 
        public static void displayAllItems(ArrayList<Item> inventory) {

            System.out.println("\n--- ALL ITEMS ---");

            for (Item item : inventory) {
                System.out.println(item);
            }
        
        }
        
        // Add a new item
        public static void addItem(ArrayList<Item> inventory, Scanner input) {

            System.out.print("Enter item name: ");
            String name = input.nextLine();

            System.out.println("Choose a category:");
            System.out.println("1. FRUITS");
            System.out.println("2. VEGETABLES");
            System.out.println("3. DAIRY");
            System.out.println("4. BAKERY");
            System.out.println("5. MEAT");

            System.out.print("Enter category number: ");
            int categoryChoice = input.nextInt();

            Category category;

            switch (categoryChoice) {
                case 1 -> category = Category.FRUITS;
                case 2 -> category = Category.VEGETABLES;
                case 3 -> category = Category.DAIRY;
                case 4 -> category = Category.BAKERY;
                case 5 -> category = Category.MEAT;
                
                default -> {
                    System.out.println("Invalid category.");
                    return;
                }
            }

            System.out.print("Enter price: ");
            double price = input.nextDouble();

            Item newItem = new Item(name, category, price);

            inventory.add(newItem);

            System.out.println("Item added successfully.");
        }

        
        // Remove an item by name
        public static void removeItem(ArrayList<Item> inventory, Scanner input) {

            System.out.print("Enter the name of the item to remove: ");
            String name = input.nextLine();

            boolean removed = false;

            for (int i = 0; i < inventory.size(); i++) {

                if (inventory.get(i).getName().equalsIgnoreCase(name)) {

                    inventory.remove(i);
                    removed = true;
                    System.out.println("Item removed successfully.");
                    break;
                }
            }

            if (!removed) {
                System.out.println("Item not found.");
            }
        }

        // Display items in a specific category
        public static void displayByCategory(ArrayList<Item> inventory, Scanner input) {

            System.out.print("Enter category (FRUITS, VEGETABLES, DAIRY, BAKERY, MEAT): ");
            String categoryInput = input.nextLine().toUpperCase();

            try {

                Category category = Category.valueOf(categoryInput);

                System.out.println("\n--- " + category + " ITEMS ---");

                for (Item item : inventory) {

                    if (item.getCategory() == category) {
                        System.out.println(item);
                    }
                }

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid category.");
            }
        }
}

        
       
        
        
        
        
        
        
   

