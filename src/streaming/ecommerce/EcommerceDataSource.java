package streaming.ecommerce;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class EcommerceDataSource {
	
	public List<Product> getProductStock(){
		return Arrays.asList(
				new Product("P1001", "Laptop", "Electronics", 2, true, 1200.00),
				new Product("P1002", "Smartphone", "Electronics", 1, true, 800.00),
				new Product("P2001", "Refrigerator", "Appliances", 1, false, 1500.00),
				new Product("P2002", "Microwave", "Appliances", 3, true, 300.00),
				new Product("P3001", "Sofa", "Furniture", 1, true, 700.00),
				new Product("P3002", "Dining Table", "Furniture", 1, true, 600.00),
				new Product("P4001", "T-Shirt", "Clothing", 5, true, 100.00),
				new Product("P4002", "Jeans", "Clothing", 2, true, 150.00),
				new Product("P5001", "Novel", "Books", 4, true, 80.00),
				new Product("P5002", "Textbook", "Books", 1, false, 200.00),
				new Product("P6001", "Action Figure", "Toys", 3, true, 90.00),
				new Product("P6002", "Board Game", "Toys", 1, true, 60.00),
				new Product("P7001", "Blender", "Appliances", 1, true, 250.00),
				new Product("P7002", "Toaster", "Appliances", 2, true, 150.00),
				new Product("P8001", "Headphones", "Electronics", 1, false, 200.00),
				new Product("P8002", "Smartwatch", "Electronics", 1, true, 300.00),
				new Product("P9001", "Dress", "Clothing", 2, true, 180.00),
				new Product("P9002", "Jacket", "Clothing", 1, false, 220.00),
				new Product("P10001", "Cookbook", "Books", 1, true, 40.00),
				new Product("P10002", "Biography", "Books", 2, true, 120.00),
				new Product("P11001", "Puzzle", "Toys", 2, true, 50.00),
				new Product("P11002", "Doll", "Toys", 1, true, 70.00)
				
				);
	}
	
	
	
	public List<Order> getAllOrders() {
		List<Order> orders = Arrays.asList(
				new Order("O1001", Arrays.asList(
						new Product("P1001", "Laptop", "Electronics", 2, true, 1200.00),
						new Product("P1002", "Smartphone", "Electronics", 1, true, 800.00)
						), 3200.00, LocalDateTime.now().minusHours(2)),
				new Order("O1002", Arrays.asList(
						new Product("P2001", "Refrigerator", "Appliances", 1, false, 1500.00),
						new Product("P2002", "Microwave", "Appliances", 3, true, 300.00)
						), 2400.00, LocalDateTime.now().minusHours(5)),
				new Order("O1003", Arrays.asList(
						new Product("P3001", "Sofa", "Furniture", 1, true, 700.00),
						new Product("P3002", "Dining Table", "Furniture", 1, true, 600.00)
						), 1300.00, LocalDateTime.now().minusHours(26)),
				new Order("O1004", Arrays.asList(
						new Product("P4001", "T-Shirt", "Clothing", 5, true, 100.00),
						new Product("P4002", "Jeans", "Clothing", 2, true, 150.00)
						), 550.00, LocalDateTime.now().minusHours(10)),
				new Order("O1005", Arrays.asList(
						new Product("P5001", "Novel", "Books", 4, true, 80.00),
						new Product("P5002", "Textbook", "Books", 1, false, 200.00)
						), 520.00, LocalDateTime.now().minusHours(20)),
				new Order("O1006", Arrays.asList(
						new Product("P6001", "Action Figure", "Toys", 3, true, 90.00),
						new Product("P6002", "Board Game", "Toys", 1, true, 60.00)
						), 330.00, LocalDateTime.now().minusHours(15)),
				new Order("O1007", Arrays.asList(
						new Product("P7001", "Blender", "Appliances", 1, true, 250.00),
						new Product("P7002", "Toaster", "Appliances", 2, true, 150.00)
						), 550.00, LocalDateTime.now().minusHours(3)),
				new Order("O1008", Arrays.asList(
						new Product("P8001", "Headphones", "Electronics", 1, false, 200.00),
						new Product("P8002", "Smartwatch", "Electronics", 1, true, 300.00)
						), 500.00, LocalDateTime.now().minusHours(8)),
				new Order("O1009", Arrays.asList(
						new Product("P9001", "Dress", "Clothing", 2, true, 180.00),
						new Product("P9002", "Jacket", "Clothing", 1, false, 220.00)
						), 580.00, LocalDateTime.now().minusHours(12)),
				new Order("O1010", Arrays.asList(
						new Product("P10001", "Cookbook", "Books", 1, true, 40.00),
						new Product("P10002", "Biography", "Books", 2, true, 120.00)
						), 280.00, LocalDateTime.now().minusHours(28)),
				new Order("O1011", Arrays.asList(
						new Product("P11001", "Puzzle", "Toys", 3, true, 50.00),
						new Product("P11002", "Doll", "Toys", 2, true, 70.00)
						), 170.00, LocalDateTime.now().minusHours(22))
			);
		return orders;
		
	}

}
