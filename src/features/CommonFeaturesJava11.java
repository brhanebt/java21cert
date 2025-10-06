package features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Todo{
	public Integer userId;
	public Integer id;
	public String title;
	public boolean completed;
}

public class CommonFeaturesJava11 {
	
	public static void main(String[] args) {
		
		//HttpClient API
		HttpClient http = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
				.header("Content-Type", "application/json")
				.GET()
				.build();
		
		try {
			//Synchronous
			HttpResponse<?> response = http.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("response.body(): "+response.body().toString().substring(0,10));
			CompletableFuture<HttpResponse<String>> res = http.sendAsync(request,HttpResponse.BodyHandlers.ofString());
			System.out.println("response.body(): "+(res.isDone()?res.get().body():"Not Done"));
			
		} catch (IOException | InterruptedException | ExecutionException e) {
			System.err.println("Exception: "+e.getMessage());
		}
		
		//New String Methods
		String empty="";
		if(empty.isEmpty()) {
			System.out.println("Empty");
		}
		String e2="  ";

		if(e2.isEmpty()) {
			System.out.println("Empty");
		} else {
			System.out.println("Not Empty");
		}

		if(e2.isBlank()) {
			System.out.println("Blank");
		}
		
		String text = "  Hello, Java 11!  \nNew Line";
		System.out.println("Stripped: '" + text.strip() + "'");
		
		String multiline = "  Line 1  \n  Line 2  \n  Line 3  ";
		multiline.lines().map(String::strip).forEach(System.out::println);
		
		System.out.println("java ".repeat(3));
	}

}
