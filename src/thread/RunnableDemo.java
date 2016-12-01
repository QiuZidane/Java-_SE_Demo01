package thread;

public class RunnableDemo implements Runnable {

	private Thread threadObj1;
	private String threadName;

	public RunnableDemo(String name) {
		threadName = name;
		System.out.println("Createing : " + threadName);

	}

	@Override
	public void run() {
		System.out.println("Running : " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + "," + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (threadObj1 == null) {
			threadObj1 = new Thread(this, threadName);
			threadObj1.start();
		}

	}

}
