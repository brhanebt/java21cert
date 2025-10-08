package streaming.ecommerce;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {
	private String customerId;
	private List<Product> products;
	private LocalDateTime lastUpdated;
	public Cart(String customerId, List<Product> products, LocalDateTime lastUpdated) {
		super();
		this.customerId = customerId;
		this.products = products;
		this.lastUpdated = lastUpdated;
	}
	

}
