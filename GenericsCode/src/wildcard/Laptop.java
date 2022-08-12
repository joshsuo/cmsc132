package wildcard;

public class Laptop extends Computer implements PortableDevice {
	private String batteryType;
	
	public Laptop(String maker, int serialNo, String batteryType) {
		super(maker, serialNo);
		this.batteryType = batteryType;
	}

	public String toString() {
		return super.toString() + " " + batteryType;
	}
	
	public int portabilityFactor() {
		return 100;
	}
}
