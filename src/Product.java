package src;

import java.util.Objects;

public final class Product {
	private static int sequence = 0;

	private final int key;
	private final String name;
	private final int price;

	public Product(String name, int price) {
		this.key = sequence++;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Product product))
			return false;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
