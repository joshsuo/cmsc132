package pizzaDecorator;

public class SmallPizza implements Pizza {
	public String ingredients() { 
		return "Small Pizza Dough"; 
	}
	
	public int cost() {
		return 8;
	}
}