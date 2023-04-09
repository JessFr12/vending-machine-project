package com.techelevator;

import com.techelevator.view.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				VendingMachine vendor = new VendingMachine();
				vendor.makeInventory();
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
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		VendingMachine fo = new VendingMachine();
		fo.makeInventory();
		cli.run();
	}
}
