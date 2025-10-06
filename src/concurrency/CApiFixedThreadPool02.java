package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DownloadFile implements Runnable {
	private String fileName;
	
	public DownloadFile(String fileName) {
		super();
		this.fileName = fileName;
		System.out.println("File download Task created for file : "+fileName);
	}
	
	@Override
	public void run() {
		System.out.println("downloading file: "+fileName+" by "+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			System.err.println("Task interrupted: "+e.getMessage());
		}
	}
	
}

public class CApiFixedThreadPool02 {
	
	public static void main(String[] args) {
		System.out.println("Main thread started!");
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0; i<5; i++) {
			executorService.submit(new DownloadFile("file-"+i+".txt"));
		}
	}

}
