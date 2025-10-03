package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CApiFixedThreadPool01 {
	
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(2);
		ThreadPoolExecutor pool = (ThreadPoolExecutor) service; 
		System.out.println("Before getPoolSize : "+pool.getPoolSize() + " Active: "+ pool.getActiveCount());
		service.submit(new Task());
		System.out.println("After 1 getPoolSize :"+pool.getPoolSize() + " Active: "+ pool.getActiveCount());
		service.submit(new Task());
		System.out.println("Before getPoolSize :"+pool.getPoolSize() + " Active: "+ pool.getActiveCount());
		service.submit(new Task());

		
		
	}

}

class Task implements Runnable{

	@Override
	public void run() {
		long duration = (long) Math.random()*5;
		System.out.println(Thread.currentThread().getName()+" - running");
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.err.println("InterruptedException: " +e.getMessage());
		}
		System.out.println(Thread.currentThread().getName()+" - done");
	}
	
}