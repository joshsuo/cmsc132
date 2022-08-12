package staticBlock;

import java.util.Calendar;

public class PersonDriver {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Today's date: " + calendar.getTime());
		
		calendar.set(1900, 2, 4);
		Person person1 = new Person("Mary", calendar.getTime());
		System.out.println(person1);
		System.out.println("Born before 2000: " + person1.bornBefore2000());
	}
}
