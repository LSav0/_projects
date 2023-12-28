package bstTest;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		Comparator<Integer> comparator = Comparator.naturalOrder();
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<>(comparator);


		bst.add(5, "abc");
		bst.add(3, "DEF");
		bst.add(7, "G");
		bst.add(2, "hi");
		bst.add(4, "jkl");
		bst.add(6, "m");
		bst.add(8, "n");


		System.out.println("Size of the tree: " + bst.size());

		System.out.println("index of: " + bst.indexOf(3));

		System.out.println("Value for key 3: " + bst.get(3));
		System.out.println("Value for key 6: " + bst.get(6));

		try {

			Pair<Integer, String>[] array = bst.toArray();

			for (Pair<Integer, String> pair : array) {

				if (pair != null) {

					System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		bst.clear();

		System.out.println("Size after clearing the tree: " + bst.size());
	}
}


