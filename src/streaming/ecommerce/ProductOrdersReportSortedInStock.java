package streaming.ecommerce;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductOrdersReportSortedInStock {
	
	//generate report that shows for each product category, the total quantity items sold 
	// from orders in the last 24 hours only include total value > 500$
	// Execlude out of stock product even if part of order
	// sort by total quantity in descending order
	
	public static void main(String[] args) {
		EcommerceDataSource ds = new EcommerceDataSource();
		
		Map<String, Integer> productsMap = ds.getAllOrders()
		.stream()
		.filter(O->O.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)) && O.getTotalValue()>500)
		
		.flatMap(O->O.getProducts().stream())
		.filter(P->P.isInStock())
		.collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getQuantity)));
		
		System.out.println(productsMap);
		
		productsMap = productsMap.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(
				Map.Entry::getKey, Map.Entry::getValue,
				(e1,e2)->e1,
				LinkedHashMap::new));
		
		System.out.println(productsMap);
	}
	
	

}
