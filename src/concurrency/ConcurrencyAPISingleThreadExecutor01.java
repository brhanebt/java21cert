package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyAPISingleThreadExecutor01 {
	
	public static void main(String[] args) {
		
		Runnable printingInventory = ()->{
			for(int i=0;i<3;i++) System.out.println("Inventory Item: "+ i);
		};
		Thread printOrders = new Thread(()->{
			for(int i=0; i<3;i++) System.out.println("Order number: "+i);
		});
		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			System.out.println("Begin");
			service.execute(printingInventory);
			service.execute(printOrders);
			System.out.println("End");
		} catch(Exception ex) {
			System.err.println("Exception: "+ex.getMessage());
		} finally {
			service.shutdown();
		}
	}

}
