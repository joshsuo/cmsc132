package pizzaDecorator;

public class WithOlive extends PizzaDecorator {
	public WithOlive(Pizza p) {
		super(p);
	}
	
	public String ingredients() { 
		return p.ingredients() + ", Olive"; 
	}
	
	public int cost() {
		return p.cost() + 2;
	}
}
