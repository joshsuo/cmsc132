package cloning;

public class Mouse implements Cloneable {
	private String type;
	private int xPos, yPos;

	public Mouse(String type) {
		this.type = type;
		xPos = yPos = 0;
	}

	public void moveMouse(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public String toString() {
		
		return type + "-> xPos: " + xPos + ", yPos: " + yPos;
		
	}

	/* Notice the return type */
	@Override
	public Mouse clone() {
		Mouse obj = null;

		try {
			obj = (Mouse) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;
	}
	
	public static void main(String[] args) {
		Mouse m1 = new Mouse("Type A");
		Mouse m2 = m1.clone();

		m2.moveMouse(5, 5);

		System.out.println(m1);
		System.out.println(m2);
	}
	
	
}