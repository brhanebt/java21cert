package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CounterTask implements Runnable {
	private static int counter = 0;
	
	public CounterTask(int id) {
		super();
		System.out.println("Counter Task created with id: "+id);
	}
	
	@Override
	public void run() {
		synchronized(CounterTask.class) {
			if(counter>=1_000_000) {
				counter=0;
			}
			counter++;
		}
		System.out.println("Counter value: "+counter+" by "+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			System.err.println("Task interrupted: "+e.getMessage());
		}
	}
}

public class CApiSingleThreadExecutor02 {
	
	public static void main(String[] args) {
		System.out.println("Main thread started!");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for(int i=0; i<5; i++) {
			executorService.submit(new CounterTask(i));
			
		}
	}

}
