package concurrency;

class TaskThread implements Runnable{
	private String name;
	
	public TaskThread(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" started by "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.err.println(name+" interrupted: "+e.getMessage());
		}
		System.out.println(name+" finished by "+Thread.currentThread().getName());
	}
}

public class JoinStart {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread started! " + Thread.currentThread().getName());
		
		Thread t1 = new Thread(new TaskThread("Task-1"));
		Thread t2 = new Thread(new TaskThread("Task-2"));
		Thread t3 = new Thread(new TaskThread("Task-3"));
		Thread t4 = new Thread(new TaskThread("Task-4"));
		Thread t5 = new Thread(new TaskThread("Task-5"));
		
		t1.start();
		t1.join(); // main thread will wait until t1 is finished
		
		t2.start();
		t2.join(250); // main thread will wait until t2 is finished or 250 ms is elapsed
		
		t3.start();
		t3.join(); // main thread will wait until t3 is finished
		
		t4.start();
		t5.start();
		
		System.out.println("Main thread finished! "+ Thread.currentThread().getName());
		
	}

}
