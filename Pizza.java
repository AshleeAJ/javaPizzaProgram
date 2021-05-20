package thePizzaPlace;
import java.util.Scanner;

public class Pizza {
	//global scanner so all methods can use
	Scanner scan = new Scanner(System.in);
	
	/**
	 * Pizza variables
	 */
	private String size;
	private String crust;
	private double price;
	
	public static final String pizza_prices = """
			Size:
				Small - $5.50
				Medium - $9.90
				Large - $13.70
			Crust:
				Thin - No extra charge
				Thick - Additional $2.20
			""";
	
	/**
	 * Pizza constructors
	 */
	public Pizza() {
		this.size = null;
		this.crust = null;
	}
	
	public Pizza(String size, String crust) {
		this.size = size;
		this.crust = crust;
	}
	
	/**
	 * Getters & Setters
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setCrust(String crust) {
		this.crust = crust;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public String getCrust() {
		return this.crust;
	}
	
	/**
	 * Methods
	 * @return
	 */
	
	public String toString() {
		return getSize() + ", " + getCrust() + "-crust pizza, with " + Topping.printToppings() + "cost: " + String.format("%.2f", price);
	}
	
	public void baseMenu() {
		System.out.println("\nPlease select a base to start creating your pizza!\n");
		// display pizza base options
		System.out.println(Pizza.pizza_prices);
	}
	
	public void baseSize() {
		while(true) {
			
			System.out.print("What size pizza would you like? ");
			String selectSize = scan.next();
			//cast to lowercase
			selectSize = selectSize.toLowerCase();
		
			if(selectSize.equals("small")) {
				setSize(selectSize);
				price += 5.50;
				break;
			}
			else if(selectSize.equals("medium")) {
				setSize(selectSize);
				price += 9.90;
				break;
			}
			else if(selectSize.equals("large")) {
				setSize(selectSize);
				price += 13.70;
				break;
			}
			else {
				System.out.print("Whoops, that isn't a valid size.\n");
			}
		}
	}
		
	public boolean crustType () {
			
		while(true) {
			
			System.out.print("What type of crust would you like? ");
			String selectCrust = scan.next();
			//cast to lowercase
			selectCrust = selectCrust.toLowerCase();
			
			if(selectCrust.equals("thin")) {
				setCrust(selectCrust);
				return true;
			}
			else if(selectCrust.equals("thick")) {
				setCrust(selectCrust);
				price += 2.20;
				return true;
			}
			else {
				System.out.print("Whoops, that isn't a crust type.\n");
				return false;
			}
		}
	}
	
	public void selectTopping() {
		/**
		 * Topping objects
		 */
		Topping TomatoPaste = new Topping("Tomato paste", 1.00, "Sauce");
		Topping BBQ = new Topping("Barbeque sauce", 1.80, "Sauce");
		Topping Ham = new Topping("Ham", 0.50, "Meat");
		Topping Salami = new Topping("Salami", 0.50, "Meat");
		Topping Bacon = new Topping("Bacon", 0.90, "Meat");
		Topping Chicken = new Topping("Chicken", 2.00, "Meat");
		Topping Shrimp = new Topping("Shrimp", 1.40, "Meat");
		Topping Capsicum = new Topping("Capsicum", 0.30, "Other");
		Topping Onion = new Topping("Onion", 0.20, "Other");
		Topping Tomatoes = new Topping("Tomatoes", 0.40, "Other");
		Topping Mushrooms = new Topping("Mushrooms", 0.45, "Other");
		Topping Pineapple = new Topping("Pineapple", 0.45, "Other");
		Topping Egg = new Topping("Egg", 0.25, "Other");
		Topping Olives = new Topping("Olives", 0.35, "Other");
		Topping Garlic = new Topping("Garlic", 0.30, "Other");
		Topping Cheese = new Topping("Cheese", 0.20, "Other");
		Topping Pumpkin = new Topping("Pumpkin", 0.50, "Other");
		
		System.out.println("\nPlease select some toppings for you pizza."
		+ "\n(please note: you can only have a maximum of 1 sauce and 3 types of meat/seafood."
		+ "\n You order cannot exceed a total of 8 toppings.)");
		// display topping menu
		System.out.print("\nSauces:");
		System.out.println(TomatoPaste.toppingInfo() + BBQ.toppingInfo());
		System.out.print("Meats/Seafoods:");
		System.out.println(Ham.toppingInfo() + Salami.toppingInfo() + Bacon.toppingInfo() + Chicken.toppingInfo()
		+ Shrimp.toppingInfo());
		System.out.print("Other toppings:");
		System.out.println(Capsicum.toppingInfo() + Onion.toppingInfo() + Tomatoes.toppingInfo() + Mushrooms.toppingInfo()
		+ Pineapple.toppingInfo() + Egg.toppingInfo() + Olives.toppingInfo() + Garlic.toppingInfo() + Cheese.toppingInfo()
		+ Pumpkin.toppingInfo());
		
		while (Topping.getSauceCount() < 1) {
			System.out.print("\nWhich sauce do you want on your pizza (or type 'none' for no sauce)? ");
			String selectSauce = scan.next();
			selectSauce = selectSauce.toLowerCase();
			if (selectSauce.equals("tomato paste") || selectSauce.equals("tomato")) {
				Topping.setSauceCount(Topping.getSauceCount() + 1);
				price += TomatoPaste.getPrice();
				Topping.toppings("tomato paste, ");
			}
			else if (selectSauce.equals("barbeque sauce") || selectSauce.equals("bbq") || selectSauce.equals("barbeque")) {
				Topping.setSauceCount(Topping.getSauceCount() + 1);
				price += BBQ.getPrice();
				Topping.toppings("barbeque sauce, ");
			}
			else if (selectSauce.equals("none")) {
				break;
			}
			else {
				System.out.println("Whoops, that isn't a valid topping.\\n");
			}
		}
		
		while (Topping.getMeatCount() < 3) {
			System.out.print("Which meat do you want on your pizza (or type 'none' for no meat)? ");
			String selectMeat = scan.next();
			selectMeat = selectMeat.toLowerCase();
			if (selectMeat.equals("ham")) {
				Topping.setMeatCount(Topping.getMeatCount() + 1);
				price += Ham.getPrice();
				Topping.toppings("ham, ");
			}
			else if (selectMeat.equals("salami")) {
				Topping.setMeatCount(Topping.getMeatCount() + 1);
				price += Salami.getPrice();
				Topping.toppings("salami, ");
			}
			else if (selectMeat.equals("bacon")) {
				Topping.setMeatCount(Topping.getMeatCount() + 1);
				price += Bacon.getPrice();
				Topping.toppings("bacon, ");
			}
			else if (selectMeat.equals("chicken")) {
				Topping.setMeatCount(Topping.getMeatCount() + 1);
				price += Chicken.getPrice();
				Topping.toppings("chicken, ");
			}
			else if (selectMeat.equals("none")) {
				break;
			}
			else {
				System.out.println("Whoops, that isn't a valid topping.\\n");
			}
		}
		
		while (Topping.getOtherCount() < 8 && Topping.getTotalCount() < 8) {
			System.out.print("Which other toppings do you want on your pizza (or type 'none' for no other toppings)? ");
			String selectOther = scan.next();
			selectOther = selectOther.toLowerCase();
			if (selectOther.equals("capsicum")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Capsicum.getPrice();
				Topping.toppings("capsicum, ");
			}
			else if (selectOther.equals("onion")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Onion.getPrice();
				Topping.toppings("onion, ");
			}
			else if (selectOther.equals("tomatoes")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Tomatoes.getPrice();
				Topping.toppings("tomatoes, ");
			}
			else if (selectOther.equals("mushrooms")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Mushrooms.getPrice();
				Topping.toppings("mushrooms, ");
			}
			else if (selectOther.equals("pineapple")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Pineapple.getPrice();
				Topping.toppings("pineapple, ");
			}
			else if (selectOther.equals("egg")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Egg.getPrice();
				Topping.toppings("egg, ");
			}
			else if (selectOther.equals("olives")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Olives.getPrice();
				Topping.toppings("olives, ");
			}
			else if (selectOther.equals("garlic")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Garlic.getPrice();
				Topping.toppings("garlic, ");
			}
			else if (selectOther.equals("cheese")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Cheese.getPrice();
				Topping.toppings("cheese, ");
			}
			else if (selectOther.equals("pumpkin")) {
				Topping.setOtherCount(Topping.getOtherCount() + 1);
				price += Pumpkin.getPrice();
				Topping.toppings("pumpkin, ");
			}
			else if (selectOther.equals("none")) {
				break;
			}
			else {
				System.out.println("Whoops, that isn't a valid topping.\\n");
			}
		}
	}
}
