package pizzaDecorator;

public class LargePizza implements Pizza {
	public String ingredients() { 
		return "Large Pizza Dough"; 
	}
	
	public int cost() {
		return 12;
	}
}