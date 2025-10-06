package features;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

record Point(double x, double y) {
	
}

public class CommonFeaturesJava21 {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable task = ()->System.out.println("Running in virtual thread: "+ Thread.currentThread().threadId());
		Thread virtualThread = Thread.ofVirtual().start(task);
		virtualThread.join();
		
		Thread.startVirtualThread(virtualThread);
		
		Thread.startVirtualThread(()->System.out.println("Running in a virtual thread: "+ Thread.currentThread().threadId()));
		String baseUrl="https://jsonplaceholder.typicode.com/posts";
		System.out.println(crawlUrls(List.of(baseUrl+"/1",baseUrl+"/2")));
		
		//Pattern matching for switch
		System.out.println(processMessageUsingPatternMatchingSwitch("WARN: message"));
		
		//record pattern matching
		
		System.out.println("processRecordPatternMatching(new Point(0,0)): "+ processRecordPatternMatching(new Point(0,0)));
		System.out.println("processRecordPatternMatching(new Point(9,9)): "+ processRecordPatternMatching(new Point(9,9)));
		
		//sequenced collections
		SequencedSet<String> sequencedSet = new LinkedHashSet<>(List.of("c","a","z","d"));
		sequencedSet.forEach(System.out::println);
		
		
	}
	
	public static List<String> crawlUrls(List<String> urls) {
	    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
	        List<Future<HttpResponse<String>>> futures = urls.stream()
	            .map(url -> executor.submit(() -> fetchData(url).get()))
	            .toList();

	        return futures.stream()
	            .map(future -> {
	                try {
	                    return future.get().body();
	                } catch (Exception e) {
	                    return "";
	                }
	            })
	            .toList();
	    }
	}

	private static CompletableFuture<HttpResponse<String>> fetchData(String url) {
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	        .uri(URI.create(url))
	        .header("Content-Type", "application/json")
	        .GET()
	        .build();
	    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
	}
	
	private static String processMessageUsingPatternMatchingSwitch(Object message) {
        return switch (message) {
            case String s when s.startsWith("ERROR") -> "Handling error: " + s;
            case String s when s.startsWith("WARN") -> "Warning logged: " + s;
            case String s -> "Info: " + s;
            case Integer i when i < 0 -> "Negative number: " + i;
            case Integer i -> "Positive number: " + i;
            case List<?> list when list.isEmpty() -> "Empty list";
            case List<?> list -> "List with " + list.size() + " elements";
            case null -> "Null message";
            default -> "Unknown message type";
        };
    }
	
	private static String processRecordPatternMatching(Point point) {
		return switch(point) {
			case Point(double x, double y) when x==y -> "diagonal";
			case Point(double x, double y) when x==0 && y==0-> "Origin";
			default -> "Not a point";
		};
	}

}
