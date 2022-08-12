package wildcard;

import java.util.*;

public class Wildcard {
	public static void printComputers(ArrayList<Computer> cl) {
		for (Computer c : cl) {
			System.out.println(c);
		}
	}

	public static void printComputersTwo(Collection<Computer> cl) {
		for (Computer c : cl) {
			System.out.println(c);
		}
	}

	public static void printObjects(ArrayList<Object> cl) {
		for (Object c : cl) {
			System.out.println(c);
		}
	}

	public static void printAny(ArrayList<?> cl) {
		 //cl.add(new Integer(10)); //Would this work?
		// cl.add(new Computer("CS", 10)); //Would this work?
		
		for (Object c : cl) {
			System.out.println(c);
		}
	}

	public static void printAnyComputer(ArrayList<? extends Computer> cl) {
		for (Computer c : cl) {
			System.out.println(c);
		}
	}

	public static void printPortables(ArrayList<? extends PortableDevice> cl) {
		for (PortableDevice p : cl) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		Laptop laptop1 = new Laptop("LaptopA", 10, "BatA");
		Computer computer1 = new Computer("ComputerA", 20);
		ArrayList<Computer> computerList = new ArrayList<Computer>();
		ArrayList<PortableDevice> portableList = new ArrayList<PortableDevice>();
		portableList.add(laptop1);
		computerList.add(laptop1);
		computerList.add(computer1);
		// printComputers(computerList); // Valid or Invalid?
		// printComputersTwo(computerList); // Valid or Invalid?
		// printObjects(computerList); // Valid or Invalid?
		// printAny(computerList); // Valid or Invalid?
		// printAnyComputer(computerList); // Valid or Invalid?
		// printAnyComputer(portableList); // Valid or Invalid?
		// printPortables(computerList); // Valid or Invalid?
		// printPortables(portableList); // Valid or Invalid?
	}
}
