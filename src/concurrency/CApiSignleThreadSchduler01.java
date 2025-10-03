package concurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CApiSignleThreadSchduler01 {
	private static int counter=0;
	
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Future<String> result1 = service.schedule(()->"First thread" +(++counter), 5, TimeUnit.SECONDS);
		Future<String> result2 = service.schedule(()->"second thread "+(++counter), 15, TimeUnit.SECONDS);
		Future<String> result3 = service.schedule(()->"third thread "+(++counter), 15, TimeUnit.SECONDS);
		Future<String> result4 = service.schedule(()->"fourth thread "+(++counter), 10, TimeUnit.SECONDS);
		
		List<Future<?>> results = List.of(result1,result2,result3,result4);
		results.forEach(r->{
			try {
				System.out.println(r.get());
			} catch (InterruptedException e) {
				System.err.println("InterruptedException: "+ e.getMessage());
				e.printStackTrace();
			} catch (ExecutionException e) {
				System.err.println("ExecutionException: "+ e.getMessage());
			}
		});
		
	}

}
