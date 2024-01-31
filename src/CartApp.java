package src;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartApp {
	private static Set<Product> productSet;

	public static void main(String[] args) {
		ProductFactory productFactory = new ProductFactory();
		List<Product> products = productFactory.getProductsFromCsvFilePath("./data.csv");

		productSet = new HashSet<>(products);

		System.out.println("고유한 상품 목록:");
		for (Product product : productSet) {
			System.out.println(product.getName() + " : " + product.getPrice());
		}

		Cart myCart = new Cart();

		myCart.addProduct(getProduct("상품1"), 1);
		myCart.addProduct(getProduct("상품2"), 2);
		myCart.addProduct(getProduct("상품3"), 3);

		myCart.removeProduct(getProduct("상품1"), 1);
		myCart.removeProduct(getProduct("상품2"), 1);

		myCart.showItems();
	}

	private static Product getProduct(String name) {
		return productSet.stream()
			.filter(p -> p.getName().equals(name))
			.findAny()
			.orElseThrow();
	}
}
