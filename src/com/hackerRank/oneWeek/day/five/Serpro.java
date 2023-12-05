package com.hackerRank.oneWeek.day.five;

import java.util.ArrayList;
import java.util.List;

public class Serpro {
	public static void main(String args[]) {
		ordenarList();
		bubbleSort();
		System.out.println(fatorial(3));
	}

	private static void ordenarList() {
		List<String> lista = new ArrayList<String>(0);
		lista.addAll(List.of("Vermelho", "Verde", "Cinza", "Amarelo"));
		System.out.println("---- Lista");
		for (String cor : lista) {
			System.out.println(cor);
		}
		System.out.println("");
		System.out.println("---- Lista ordenada");
		lista.stream().sorted().forEach(System.out::println);
	}

	private static int fatorial(int i) {
		if (i <= 1) {
			return 1;
		}
		return i * fatorial(i - 1);
	}

	private static void bubbleSort() {
		List<Integer> lista = new ArrayList<Integer>(0);
		lista.addAll(List.of(8, 9, 3, 5, 1, 2, 6));

		System.out.println("Desordenado:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}

		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - i - 1; j++) {
				if (lista.get(j) > lista.get(j + 1)) {
					int temp = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, temp);
				}
			}
		}

		System.out.println("Ordenado:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
