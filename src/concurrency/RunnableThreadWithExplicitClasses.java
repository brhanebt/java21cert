package concurrency;

class Common{
	void getThreadDetails(){
		System.out.println("getName: "+Thread.currentThread().getName());
		System.out.println("isDaemon: "+Thread.currentThread().isDaemon());
		System.out.println("getPriority: "+Thread.currentThread().getPriority());
		System.out.println("threadId: "+Thread.currentThread().threadId());
		System.out.println("activeCount: "+Thread.activeCount());
		System.out.println("getThreadGroup: "+Thread.currentThread().getThreadGroup());
		System.out.println("getState: "+Thread.currentThread().getState());
		System.out.println("isAlive: "+Thread.currentThread().isAlive());
		System.out.println("isInterrupted: "+Thread.currentThread().isInterrupted());
		System.out.println("isVirtual: "+Thread.currentThread().isVirtual());
	}
}

class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("This class extends Thread");
		new Common().getThreadDetails();
		
	}
}

class MyRunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("This class implements Runnable");
		new Common().getThreadDetails();
		System.out.println();
	}
	
}

public class RunnableThreadWithExplicitClasses {
	public static void main(String[] args) {
		System.out.println("Main thread");
		new Common().getThreadDetails();
		
		Thread thread1 = new MyThread();
		thread1.start();
		
		Thread thread2 = new Thread(new MyRunnableThread());
		thread2.start();
		
		System.out.println("thread1 status: "+ thread1.getState());
		System.out.println("thread2 status: "+ thread1.getState());
		
	}

}
