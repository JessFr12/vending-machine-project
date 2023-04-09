package com.techelevator;
import com.techelevator.view.*;

public class Purchaser {
    private Product choice;
    private double userBalance=0;
    private double machineBalance;
    private double changeDue;

    public Purchaser(Product choice) {
        this.choice = choice;
    }

    public Product getChoice() {
        return choice;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public double getMachineBalance() {
        return machineBalance;
    }

    public double getChangeDue() {
        return changeDue;
    }

    public void purchaseProduct(Product c){
        double price = c.getPrice();
        if(price<userBalance){
            userBalance-=price;
            c.setStock(c.getStock()-1);
            System.out.println(c.getName()+" "+c.getPrice()+" "+getUserBalance());
            System.out.println(c.getMessage());

        }
    }
    public void dispenseChange(){

    }
    public void feedMoney(int amount){
        userBalance+=amount;
    }
}
