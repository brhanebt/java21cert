package concurrency;

public class SimpleThread02 {
	private static int counter=0;
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<1_000_000;i++) counter++;
		}).start();;
		
		while(counter<1_000_000) {
			System.out.println("Not Reached yet: "+ counter);
			try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				System.err.println("IException: "+e.getMessage());
			}
		}
		System.out.println("Reached: "+ counter);
	}

}
