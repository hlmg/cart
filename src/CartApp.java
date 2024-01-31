package src;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartApp {
	public static void main(String[] args) {
		List<Product> products = List.of(
			new Product("상품1", 1000),
			new Product("상품2", 2000),
			new Product("상품3", 3000),
			new Product("상품4", 4000)
		);

		Set<Product> productSet = new HashSet<>(products);

		System.out.println("고유한 상품 목록:");
		for (Product product : productSet) {
			System.out.println(product.getName() + " : " + product.getPrice());
		}

		// 장바구니 생성
		// Cart myCart = new Cart();

		// TODO: 상품을 장바구니에 추가
		// TODO: 상품을 장바구니에서 제거
		// TODO: 장바구니에 현재 담긴 상품 출력 (상품 이름, 각 상품의 개수)
	}
}
