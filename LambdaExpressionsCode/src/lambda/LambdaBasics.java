package lambda;

public class LambdaBasics {
	public static void main(String[] args) {
		Task anonymousVersion = new Task() {
			public int compute(int x) {
				return x + x;
			}
		};
		System.out.println(anonymousVersion.compute(10));

		Task lambdav1 = (int x) -> {
			return x + x;
		};
		System.out.println(lambdav1.compute(10));

		Task lambdav2 = (x) -> x + x;
		System.out.println(lambdav2.compute(10));

		Task lambdav3 = x -> x + x;
		System.out.println(lambdav3.compute(10));

		AnotherTask lambdav4 = () -> 10;
		System.out.println(lambdav4.analyze());

		Processor lambdav5 = (int x, float y) -> x * y;
		System.out.println(lambdav5.increase(10, 5));

		pdata((x, y) -> x * y);
	}

	public static void pdata(Processor p) {
		System.out.println(p.increase(10, 60));
	}
}
