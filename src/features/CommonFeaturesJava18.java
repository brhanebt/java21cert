package features;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import com.sun.net.httpserver.*;

public class CommonFeaturesJava18 {
	
	public static void main(String[] args) {
		
		//UTF-8 made default for consistency
		
		try {
			Files.readAllLines(Path.of("./CommonFeaturesJava18.java")); // UTF-8 default 
			Files.writeString(Path.of("output.txt"), "Hello World");
		} catch (IOException e) {
			System.err.println("Exception: "+ e.getMessage());
		}
		
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
			server.createContext("/", new HttpHandler() {

				@Override
				public void handle(HttpExchange exchange) throws IOException {
					//handle requests here
				}
				
			});
			
			server.start();
			System.out.println("Server running on port: "+ server.getAddress());
		} catch (IOException e) {
			System.err.println("Exception: "+ e.getMessage());
		}
		
		
	}

}
