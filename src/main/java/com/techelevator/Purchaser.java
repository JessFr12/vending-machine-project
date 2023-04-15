package com.techelevator;
import com.techelevator.view.*;

public class Purchaser {
    private final double NICKEL = 0.05;

    private final double QUARTER = 0.25;
    private final double DIME = 0.1;
    private Product choice;
    private double userBalance=0;


   /* public Purchaser(Product choice) {
        this.choice = choice;
    }*/

    public Product getChoice() {
        return choice;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public void setChoice(Product choice) {
        this.choice = choice;
    }

    //this method needs to take a slotID instead of a product
    public void purchaseProduct(Product c){
        //test effects not command line output

        double price = c.getPrice();
        if(price<userBalance&&c.isInStock()){
            userBalance-=price;
            c.setStock(c.getStock()-1);
          //  System.out.println(c.getName()+" "+c.getPrice()+" "+getUserBalance());
            System.out.println(c.getMessage());
            if(c.getStock()==0){
                c.setInStock(false);
            }

        }
        else if(!c.isInStock()){
            System.out.println("SOLD OUT");
        }
        else if(price>userBalance){
            System.out.println("Insufficient funds provided.");
        }
    }
    public void dispenseChange(){
        //return something
        //needs fixing
        double numQuarters = Math.floor(userBalance/QUARTER);
        double remainder = userBalance%QUARTER;
        double numDimes = Math.floor(remainder/DIME);
        remainder = remainder%DIME;
        double numNickels = Math.floor(remainder/NICKEL);
        setUserBalance(0);


    }
    public void feedMoney(int amount){
        userBalance+=amount;
    }
}
