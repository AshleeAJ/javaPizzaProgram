package thePizzaPlace;

public class Topping {
	static StringBuilder topping_list = new StringBuilder();
	/**
	 * Topping variables
	 */
	
	private String name;
	private double price;
	private String type; // to help with count
	
	// counts for amount of each topping type
	private static int sauceCount = 0; // 1 or none
	private static int meatCount = 0; // 3 or none
	private static int otherCount = 0; // 8 or none
	private static int totalCount =
			getSauceCount() + getMeatCount() + getOtherCount(); // cannot exceed 8
	
	/**
	 * Topping constructors
	 */
	
	public Topping() {
		this.name = null;
		this.price = 0.0;
		this.type = null;
	}
	
	public Topping(String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	/**
	 * Getters & Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static int getSauceCount() {
		return sauceCount;
	}

	public static void setSauceCount(int sauceCount) {
		Topping.sauceCount = sauceCount;
	}
	
	public static int getMeatCount() {
		return meatCount;
	}

	public static void setMeatCount(int meatCount) {
		Topping.meatCount = meatCount;
	}
	
	public static int getOtherCount() {
		return otherCount;
	}

	public static void setOtherCount(int otherCount) {
		Topping.otherCount = otherCount;
	}
	
	// only need getter for total count; sum of all other counts
	public static int getTotalCount() {
		return totalCount;
	}
	
	/**
	 * Methods
	 */
	
	public String toppingInfo() {
		return "\n\t" + getName() + " - $" + String.format("%.2f", getPrice()); // string format from: https://stackoverflow.com/questions/5710394/how-do-i-round-a-double-to-two-decimal-places-in-java
	}
	
	public static void toppings(String addTopping) {
		topping_list.append(addTopping);
	}
	
	public static StringBuilder printToppings() {
		return topping_list;
	}
}
