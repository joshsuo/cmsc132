package genericMethod;

public class Utilities {
	public static <T extends Comparable<T>> T minimum(T value1, T value2) {
		return value1.compareTo(value2) < 0 ? value1 : value2;
	}

	public static <T extends Comparable<T>> T maximum(T value1, T value2) {
		return value1.compareTo(value2) < 0 ? value2 : value1;
	}

	public static <T extends Comparable<T>> boolean isIncreasing(T value1, T value2, T value3) {
		return value1.compareTo(value2) < 0 && value2.compareTo(value3) < 0;
	}
}
