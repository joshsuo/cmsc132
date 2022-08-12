package pizzaDecorator;

public class Driver {
	public static void main(String[] args) {
		Pizza ourPizza;

		ourPizza = new WithTomato(new WithOlive(new LargePizza()));
		/* returns cost: 12 + 2 + 3 */
		System.out.println(ourPizza.ingredients() + ", Cost: " + ourPizza.cost());

		ourPizza = new WithTomato(new WithTomato(new SmallPizza()));
		/* returns Cost: 8 + 3 + 3 */
		System.out.println(ourPizza.ingredients() + ", Cost: " + ourPizza.cost());
	}
}
