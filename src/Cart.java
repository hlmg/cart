package src;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private final Map<Product, Integer> items = new HashMap<>();

	public void addProduct(Product item, int quantity) {
		validate(item, quantity);

		items.put(item, items.getOrDefault(item, 0) + quantity);
	}

	private void validate(Product item, int quantity) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (quantity <= 0) {
			throw new IllegalArgumentException();
		}
	}

	public void removeProduct(Product product, int quantity) {
		validate(product, quantity);
		Map.Entry<Product, Integer> entry = items.entrySet().stream()
			.filter(e -> e.getKey().equals(product))
			.findAny()
			.orElseThrow();

		if (entry.getValue() < quantity) {
			throw new IllegalArgumentException();
		}

		if (entry.getValue() == quantity) {
			items.remove(product);
			return;
		}

		items.put(product, entry.getValue() - quantity);
	}

	public void showItems() {
		System.out.println("장바구니 목록");
		for (Map.Entry<Product, Integer> productIntegerEntry : items.entrySet()) {
			System.out.printf("%s : %s개%n", productIntegerEntry.getKey().getName(), productIntegerEntry.getValue());
		}
	}
}
