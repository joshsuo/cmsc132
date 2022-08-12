package pizzaDecorator;

public abstract class PizzaDecorator implements Pizza {
	protected Pizza p;
	
	public PizzaDecorator(Pizza p) {this.p = p;}
	public abstract int cost();
	public abstract String ingredients();
}
