package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProductFactory {

	public List<Product> getProductsFromCsvFilePath(String path) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Path.of(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return lines.stream()
			.map(line -> line.split(","))
			.map(array -> new Product(array[0], Integer.parseInt(array[1])))
			.toList();
	}
}
