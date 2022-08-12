package pizzaDecorator;

public class WithTomato extends PizzaDecorator {
	public WithTomato(Pizza p) {
		super(p);
	}
	
	public String ingredients() { 
		return p.ingredients() + ", Tomato"; 
	}
	
	public int cost() {
		return p.cost() + 3;
	}
}