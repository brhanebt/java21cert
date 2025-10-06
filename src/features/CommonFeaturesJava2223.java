package features;

import java.time.Duration;

public class CommonFeaturesJava2223 {
	
	public static void main(String[] args) {
		//Java 21 unnamed variables for unused variables for better readability
		
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (InterruptedException _) {
			System.err.println("Thread.sleep failed with InterruptedException!");
		}
		
		//Java 24
		
		
	}

}
