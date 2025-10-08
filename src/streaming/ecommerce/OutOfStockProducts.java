package streaming.ecommerce;

import java.util.List;

public class OutOfStockProducts {
	
	public static void main(String[] args) {
		EcommerceDataSource ds= new EcommerceDataSource();
		
		List<Product> outOfStockProducts = 
		ds.getAllOrders()
		.stream()
		.flatMap(order->order.getProducts().stream())
		.filter(op->{
			Product stockProduct = ds.getProductStock().stream()
					.filter(p->p.getProductId().equals(op.getProductId())).findFirst().orElse(null);
			return stockProduct != null && op.getQuantity()>stockProduct.getQuantity();
		}).toList();
		
		System.out.println(outOfStockProducts);
		
	}

}
