package com.mycompany.grocerystore_inventory;

public class Item {
    private String name;
    private Category category;
    private double price;
    
    
    public Item(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public String getName() {
     return name;   
    }
    
    public Category getCategory() {
     return category;   
    }
    
    public double getPrice() {
     return price;   
    }
    
    @Override
    public String toString() {
        return name + " - " + category + " - R" + price;
    }
}
