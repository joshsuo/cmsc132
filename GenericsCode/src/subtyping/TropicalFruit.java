package subtyping;

public class TropicalFruit extends Fruit {
	private String tropicalArea;

	public TropicalFruit(String name, String color, String tropicalArea) {
		super(name, color);
		this.tropicalArea = tropicalArea;
	}

	public String toString() {
		return super.toString() + " " + tropicalArea;
	}
}
