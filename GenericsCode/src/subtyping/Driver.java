package subtyping;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		arrays();
	}

	public static void lists() {
		// ArrayList<Fruit> fruitArrayList = new ArrayList<TropicalFruit>(); //Compilation Error
	}

	public static void arrays() {
		TropicalFruit[] tropicalFruitArray = new TropicalFruit[2];
		tropicalFruitArray[0] = new TropicalFruit("mango", "yellow", "Caribbean");
		tropicalFruitArray[1] = new TropicalFruit("banana", "yellow", "Caribbean");
		Fruit[] fruitArray = tropicalFruitArray;
		for (Fruit fruit : fruitArray)
			System.out.println(fruit);
		// tropicalFruitArray[0] = new Fruit("tomato", "red"); //Compilation error

		 //fruitArray[0] = new Fruit("pear", "green"); //Generates exception
	}
}