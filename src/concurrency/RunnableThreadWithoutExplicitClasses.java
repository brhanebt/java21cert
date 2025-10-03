package concurrency;

public class RunnableThreadWithoutExplicitClasses {
	
	public static void main(String[] args) {
		System.out.println("Threads ... ");
		Runnable printRecords = () -> {
			for(int i=0; i<3; i++) {
				System.out.println("Reusable runnable thread - 1 Printing records ...."+ i);
			}
		};
		Runnable printRecords2 = () -> {
			for(int i=0; i<3; i++) {
				System.out.println("Reusable runnable thread - 2 Printing records ...."+ i);
			}
		};
		new Thread(printRecords).run();
		new Thread(()->System.out.println("Thread - 3")).run();
		new Thread(printRecords2).run();

		System.out.println("Threads ... ");
	}

}
