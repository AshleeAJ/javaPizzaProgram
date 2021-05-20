package thePizzaPlace;
import java.util.Scanner;

public class Main {
	
	StringBuilder receipt = new StringBuilder();
	//receipt outside of loop so multiple pizzas can be added to receipt
	boolean stillRunning = true;
	Scanner scan = new Scanner(System.in);
	int userInput;
	
	public void start() {
		int choice;
		while (stillRunning) {
			showMainMenu();
			choice = getUserSelection(1,3);
			processChoiceMainMenu(choice);
		}
	}
	
	public void showMainMenu() {
		System.out.println("\nPlease select an option: ");
		System.out.println("\t1. Add pizza to order");
		System.out.println("\t2. Confirm order and print receipt");
		System.out.println("\t3. Cancel order and quit");
	}
	
	public void processChoiceMainMenu(int choice) {
		switch(choice) {
		case 1:
			//1. order pizza
			Pizza pizza = new Pizza();
			//choose pizza base
			pizza.baseMenu();
			pizza.baseSize();
			pizza.crustType();
			//choose pizza toppings
			pizza.selectTopping();
			//add pizza order to string builder for receipt
			receipt.append(pizza.toString());
			receipt.append("\n"); // space between orders
			// clear topping list and counts so next pizza can be ordered with new toppings
			Topping.topping_list.setLength(0);
			Topping.setSauceCount(0);
			Topping.setMeatCount(0);
			Topping.setOtherCount(0);
			break;
		case 2:
			//2. confirm and print receipt
			System.out.println("Thanks for shopping at The Pizza Place, here's your receipt: \n");
			System.out.println(receipt);
			stillRunning = false;
			break;
		case 3:
			//3. cancel order and quit
			System.out.println("Goodbye.");
			stillRunning = false;
		
		}
	}
	
	public int getUserSelection(int lower, int upper) {
		if (lower > upper) {
			return 0;
		}
		do {
			System.out.print("> ");
			userInput = scan.nextInt();
			scan.nextLine();
			if (userInput < lower || userInput > upper) {
				System.out.println("invalid choice");
			}
		} while (userInput < lower || userInput > upper);
		System.out.println();
		return userInput;
	}
	
	public static void main(String[] args) {
		/**
		 * Main loop
		 */
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("| Welcome to The Pizza Place! |");
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Main program = new Main();
		program.start();
		
	}

}
