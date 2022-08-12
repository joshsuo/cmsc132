package wildcard;

public class Computer {
	private String maker;
	private int serialNo;
	
	public Computer(String maker, int serialNo) {
		super();
		this.maker = maker;
		this.serialNo = serialNo;
	}
	
	public String toString() {
		return maker + " " + serialNo;
	}
}
