
public enum MenuItem {

	GRITS("Grits", 235),
	PANCAKES("Pancakes", 330),
	BURRITO("Burrito", 875),
	BACON_AND_EGGS("Bacon & Eggs", 450),
	GREEK_SALAD("Greek Salad", 70),
	CAESAR_SALAD("Caesar Salad", 50),
	SANDWICH("Sandwich", 435);

	public final String name;
	private int calorieCount;

	MenuItem(String name, int calorieCount) {
		this.name = name;
		this.calorieCount = calorieCount;
	}
	
	public int getCalorieCount() {
		return calorieCount;
	}

}
