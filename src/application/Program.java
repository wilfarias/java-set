package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>(); // mais rápido, desconsidera a ordem
		// Set<String> set = new TreeSet<>(); // mais lento, ordena pelo "compareTo"
		// Set<String> set = new LinkedHashSet<>(); // intermediário, ordena pela
		// inserção

		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");

		set.removeIf(x -> x.charAt(0) == 'T');

		System.out.println(set.contains("Notebook"));

		for (String p : set) {
			System.out.println(p);
		}

		// Operações de conjunto ---------------------

		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

		// union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);

		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);

		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);

		// Teste de Igualdade com Set -------------------------

		Set<Product> setp = new HashSet<>();

		setp.add(new Product("TV", 900.0));
		setp.add(new Product("Notebook", 1200.0));
		setp.add(new Product("Tablet", 400.0));

		Product prod = new Product("Notebook", 1200.0);

		System.out.println(setp.contains(prod)); // verdadeiro apenas se implementados os métodos 
												//hashcode e equals na classe product, pois compara o conteúdo
												// sem os métodos, compara-se ponteiros

		// Comparação de Elementos com TreeSet ---------------------

		Set<Product> setTree = new TreeSet<>();

		setTree.add(new Product("TV", 900.0));
		setTree.add(new Product("Notebook", 1200.0));
		setTree.add(new Product("Tablet", 400.0));
		
		for (Product p : setTree) {
			//Ao usar o TreeSet, a comparação de objetos
			//só é possivel ao implementar o método CompareTo
			//pertencente a interface Comparable
			//na classe do objeto a ser comparado - no caso Product 
			System.out.println(p);
		}

	}

}
