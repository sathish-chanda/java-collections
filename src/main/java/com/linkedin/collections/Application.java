package com.linkedin.collections;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 2000);

		NavigableSet<Integer> numberTree = new TreeSet<>(numbers);

		// Numbers iterated through ascending order.
		numberTree
				.stream()
				.forEach(System.out::println);

		// Numbers iterated through descending order.
		numberTree.descendingSet()
				.stream()
				.forEach(System.out::println);


		// Number all less than given number.
		numberTree.headSet(1750)
				.stream()
				.forEach(System.out::println);

		// Number all higher than given number
		numberTree.tailSet(1750)
				.stream()
				.forEach(System.out::println);
	}
}
