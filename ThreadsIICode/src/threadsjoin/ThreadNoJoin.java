package threadsjoin;

public class ThreadNoJoin extends Thread {

	public void run() {
		for (int i = 1; i <= 3; i++) {
			try {
				sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new ThreadNoJoin();
		Thread thread2 = new ThreadNoJoin();

		thread1.start();
		thread2.start();

		System.out.println("Done");
	}
}