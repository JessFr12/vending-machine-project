package com.techelevator;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import com.techelevator.view.*;
import org.w3c.dom.ls.LSOutput;

public class VendingMachine {

    public String readInventory() {
        File vendor = new File("vendingmachine.csv");
        List<Product> inventory = new ArrayList<>();
        try (Scanner readInventory = new Scanner(vendor)) {
            while (readInventory.hasNextLine()) {
                String line = readInventory.nextLine();
                String[] attributes = line.split("|");
                this.makeInventoryItem(attributes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
        return null;
    }



   /* public String getType(String[] atts){
        List<String> types = new ArrayList<>();
        types.add("Candy");
        types.add("Drink");
        types.add("Gum");
        types.add("Chip");
        for(String s : types){
            if(atts[3].equals(s)){
                return s;
            }
        }
    }*/

    public void makeInventoryItem(String[] atts){
        if(atts[3].equals("Candy")){
            Product c = new Candy(Double.parseDouble(atts[2]), atts[1], atts[0]);
            inventory.add(c);
        }
        else if (atts[3].equals("Drink")){
            Product c = new Drink(Double.parseDouble(atts[2]), atts[1], atts[0]);
            inventory.add(c);
        }
        else if (atts[3].equals("Chip")){
            Product c = new Chips(Double.parseDouble(atts[2]), atts[1], atts[0]);
            inventory.add(c);
        }
        else if (atts[3].equals("Gum")){
            Product c = new Gum(Double.parseDouble(atts[2]), atts[1], atts[0]);
            inventory.add(c);
        }
    }


}
