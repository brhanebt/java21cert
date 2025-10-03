package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CApiSingleThreadExecutorCallable02 {
	private static int counter=0;
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		try {
			Future<?> result = service.submit(()->counter+10);
			System.out.println("Reached: "+ result.get(10,TimeUnit.SECONDS));
			
		} catch(TimeoutException | InterruptedException | ExecutionException e) {
			System.err.println();
		} finally {
			service.shutdown();
		}
	}
}
