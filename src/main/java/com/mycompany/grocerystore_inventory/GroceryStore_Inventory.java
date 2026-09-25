// Refrences:
//https://www.google.com/search?q=how+to+initialize+an+array+with+specific+objects+in+java%3F&sca_esv=fac01c4ba4c5f10b&sxsrf=APpeQnvz4qkGwqDL-1NdLZtI33BLk3WKQg%3A1790356368701&source=chrome.ob&fbs=ABfTbFVyMZGZf1hfvX9uKjN_-G8cqu7ocb7U6ah0xpkIrGMK4LpKPoHZrc4HVz9uOAATjT1g2XbMUNYTWk-OmYpiK--qaigyNre7a9Fsg8QLr9z5lJegIZGuhAshyGX8vZNsidOe2y3k9Yup0oEbg7vSMYlsXcLQONuEYGQeYUXcOUWQavxf8tiuiFRXsrG1FqFEc3jvZgjn&vsint=&aep=1&ntc=1&cs=1&sa=X&ved=2ahUKEwjKrIKbnYqXAxU_a0EAHQcnAOYQ2J8OegQIExAD&biw=1280&bih=559&dpr=1.5&mstk=AUtExfAoW0JKLwB_MXv1DPVcc65jrFae3K-7ZKEQRVCqUIWeOxw89EyABpucjelOfo3Osimn3P_l8WyJ2p7_vA-UsA-kuJ_1zRDJjrTZodCZxapDSUZEd771pUXKtWJq4rw5aPzT05YNG9ATJtW_JORfoyxn8D3s3XW3cMMB2Mpe7WydjiLddbTDdDbGYUBi8BW997XPEX6mlLTYYbZ3xVjJWFxrn2GQsFRO6BfGEZDzfUDy966nepAg6iW1lcE8sUKag9E6CgPbCo60cGZoUJt954lofS7IErbWkUYyu2bCmfUu1vzD_x2rW2MTF7-c8oOxCeoX0Jeyrybmmg&csuir=1&mtid=lKu2avWWFp2DhbIP0-Kk6Qs&udm=50&lns_mode=cvst
// Above is the link of how to initialize an array with specific objects
// https://www.w3schools.com/java/java_arraylist.asp : arraylist
// https://www.w3schools.com/java/java_try_catch.asp : try ... catch

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
        
        
        // implementig an arraylist that will store more items than the array
        ArrayList<Item> inventory = new ArrayList<>();
        
        // adding items from the initial array to the arraylist to be more manageable
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
        
        // method displaying all items stored in the arrylist
        public static void displayAllItems(ArrayList<Item> inventory) {

            System.out.println("\n--- ALL ITEMS ---");

            for (Item item : inventory) {
                System.out.println(item);
            }
        
        }
        
        
        // method adding a new item to the arraylist
        public static void addItem(ArrayList<Item> inventory, Scanner input) {

            System.out.print("Enter item name: ");
            String name = input.nextLine();
            

            // displaying the menu to allow the user to choose
            
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

        
        // method removing an item by name from the arrylist
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
        

        // method displaying only items belonging to a specific category based on the user's input
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

        
       
        
        
        
        
        
        
   

