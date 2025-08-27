package com.basket.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.basket.core.Shopping;

public class UnitTests {

	private Shopping basket;

	@BeforeEach
	void setup() {
		basket = new Shopping();
	}

	@Test
	void testEmptyBasket() {
		int result = basket.checkout(Collections.emptyList());
		assertEquals(0, result, "Empty basket should cost 0p");
	}

	@Test
	void testSingleItem() {
		int result = basket.checkout(Arrays.asList("Apple"));
		assertEquals(35, result, "Apple should cost 35p");
	}

	@Test
	void testMultipleItemsWithoutOffers() {
		int result = basket.checkout(Arrays.asList("Apple", "Banana"));
		assertEquals(55, result, "Apple + Banana = 55p");
	}

	@Test
	void testMelon_2Items() {
		int result = basket.checkout(Arrays.asList("Melon", "Melon"));
		assertEquals(50, result, "2 Melons = 50p (BOGOF)");
	}

	@Test
	void testMelon_3Items() {
		int result = basket.checkout(Arrays.asList("Melon", "Melon", "Melon"));
		assertEquals(100, result, "3 Melons = 100p");
	}

	@Test
	void testLime3For2_3Items() {
		int result = basket.checkout(Arrays.asList("Lime", "Lime", "Lime"));
		assertEquals(30, result, "3 Limes = 30p (3 for 2)");
	}

	@Test
	void testLime3For2_4Items() {
		int result = basket.checkout(Arrays.asList("Lime", "Lime", "Lime", "Lime"));
		assertEquals(45, result, "4 Limes = 45p");
	}

	@Test
	void testMixedBasketWithOffers() {
		int result = basket.checkout(Arrays.asList("Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime"));
		assertEquals(135, result, "Mixed basket total = 135p");
	}

	@Test
	void testLargeBasket() {
		int result = basket.checkout(
				Arrays.asList("Apple", "Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime", "Melon"));
		assertEquals(235, result, "Large basket total = 235p");
	}

	@Test
	void testBananasOnly() {
		int result = basket.checkout(Arrays.asList("Banana"));
		assertEquals(20, result, "Single Banana = 20p");
	}
}
