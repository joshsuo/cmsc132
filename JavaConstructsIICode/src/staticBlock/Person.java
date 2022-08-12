package staticBlock;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	private String name;
	private Date birthDate;
	private static final Date MILLENIUM;
	
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
		MILLENIUM = gmtCal.getTime();
	}

	public Person(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthDate=" + birthDate + "]";
	}

	public boolean bornBefore2000() { // FASTER!
		return birthDate.before(MILLENIUM);
	}
}
