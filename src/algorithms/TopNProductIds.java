package algorithms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record User(int id, String name, List<Product> products) {
	
}

record Product(int id, String productName) {
	
}

public class TopNProductIds {
	
	public static void main(String[] args) {
		Product product1 = new Product(1, "Product 1");
		Product product2 = new Product(2, "Product 2");
		Product product3 = new Product(3, "Product 3");
		Product product4 = new Product(4, "Product 4");
		Product product5 = new Product(5, "Product 5");
		Product product6 = new Product(6, "Product 6");
		
		User user1 = new User(1, "User 1", List.of(product1, product3));
		User user2 = new User(2, "User 2", List.of(product2, product3, product4));
		User user3 = new User(3, "User 3", List.of(product1, product4, product5, product6));
		User user4 = new User(4, "User 4", List.of(product2, product3, product4));
		User user5 = new User(5, "User 5", List.of(product1, product3, product5));
		User user6 = new User(6, "User 6", List.of(product1, product2, product3, product4, product5, product6));
		
		List<User> users = List.of(user1, user2, user3, user4, user5, user6);
		List<Integer> top3ProductIds = findTopNProductIds(users, 3);
		System.out.println("Top 3 Product IDs: " + top3ProductIds);
		
		List<Integer> top5ProductIds = findTopNProductIds(users, 5);
		System.out.println("Top 5 Product IDs: " + top5ProductIds);
		Map<Integer, Long> productsCountMap = getProductCountMap(users);
		System.out.println("Product Count Map: " + productsCountMap);
	}

	private static Map<Integer, Long> getProductCountMap(List<User> users) {
		return users.stream()
				     .flatMap(user -> user.products().stream())
				     .collect(Collectors.groupingBy(Product::id, Collectors.counting()));
	}

	private static List<Integer> findTopNProductIds(List<User> users, int i) {
		return users.stream()
		     .flatMap(user -> user.products().stream())
		     .collect(Collectors.groupingBy(Product::id, Collectors.counting()))
		     .entrySet()
		     .stream()
		     .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		     .limit(i)
		     .map(entry -> entry.getKey())
		     .collect(Collectors.toList());
	}

}
