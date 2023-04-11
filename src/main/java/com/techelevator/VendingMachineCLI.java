package com.techelevator;

import com.techelevator.view.*;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;
	private Scanner input = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			VendingMachine vendor = new VendingMachine();
			vendor.makeInventory();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (Product p : vendor.inventory){
					String outputLine = "";
					outputLine+=p.getSlotID()+" ";
					outputLine+=p.getName()+" ";
					outputLine+=String.format("%.2f",p.getPrice())+" ";
					outputLine+=p.getStock();
					System.out.println(outputLine);
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println(vendor.getUserBalance());
				menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(choice.equals(PURCHASE_MENU_FEED_MONEY)){
					System.out.println("Enter a whole dollar amount: ");
					int amount = Integer.parseInt(input.nextLine());
					vendor.feedMoney(amount);


				}
				else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
					System.out.println("Enter a product ID:");
					String id = input.nextLine();

					Product ch = vendor.getInventoryItem(id);
					vendor.purchaseProduct(ch);
					//menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				}
				else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)){
					vendor.dispenseChange();

				}

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
