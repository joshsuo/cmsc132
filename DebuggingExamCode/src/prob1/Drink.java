package prob1;

public class Drink {
	private String name;
	private int calories;

	public Drink(String name, int calories) {
		super();
		this.name = name;
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", calories=" + calories + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
}
