package prob1;

import java.util.Arrays;

public class Restaurant {
	private String name;
	private Drink allDrinks[];
	private int max, curr;

	public Restaurant(String name, int max) {
		this.name = name;
		this.allDrinks = new Drink[max];
		this.max = max;
		curr = 0;
	}

	public String getName() {
		return name;
	}

	public Restaurant addDrink(String name, int calories) {
		if (validDrink(name, calories)) {
			allDrinks[curr++] = new Drink(name, calories);
		}

		return this;
	}

	public static boolean validDrink(String name, int calories) {
		boolean answer = (name != null && calories >= 0);
		
		return answer;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", allDrinks=" + Arrays.toString(allDrinks) + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Drink[] getAllDrinks() {
		return allDrinks;
	}

	public void setAllDrinks(Drink[] allDrinks) {
		this.allDrinks = allDrinks;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCurr() {
		return curr;
	}

	public void setCurr(int curr) {
		this.curr = curr;
	}
}
