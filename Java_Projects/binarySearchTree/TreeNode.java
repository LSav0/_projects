package bstTest;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class TreeNode<K extends Comparable<K>, V> {

	TreeNode<K, V> left = null;
	TreeNode<K, V> right = null;
	private K key;
	private V value;
	private Comparator<K> comparator;

	public TreeNode(K key, V value, Comparator<K> comparator) {

		left = null;
		right = null;
		this.value = value;
		this.key = key;
		this.comparator = comparator;

	}
	
	 public K getKey() {

	    return key;

	}

	public V getValue() {

		return value;

	}

	public TreeNode<K, V> getLeft() {

		return left;

	}

	public void setLeft(TreeNode<K, V> left) {

		this.left = left;

	}

	public TreeNode<K, V> getRight() {

		return right;

	}

	public void setRight(TreeNode<K, V> right) {

		this.right = right;

	}

	public V find(K key) {

		V result = null;

		if (this.key.equals(key)) { 

			result = value;

		} else if (comparator.compare(key, this.key) <= 0) { 


			if (left != null) {

				result = left.find(key);
			}

		} else {

			if (right != null) {

				result = right.find(key);
			}

		}
		return result;

	}

	public boolean insert(K key, V value) { 

		if (this.value.equals(value)) {

			this.value = value;
			this.key = key;

			return false;

		}

		boolean result = false;

		if (comparator.compare(key, this.key) <= 0) { 

			if (left == null) {

				left = new TreeNode<K, V>(key, value, comparator);
				result = true;

			} else {

				result = left.insert(key, value);

			}

		} else { 

			if (right == null) {

				right = new TreeNode<K, V>(key, value, comparator);

				result = true;

			} else {

				result = right.insert(key, value);

			}
		}

		return result;

	}

	public V find(Predicate<V> searcher) {

		V result = null;

		if (left != null) {

			result = left.find(searcher);

			if (result != null){

				return result;
			}
		}

		if (searcher.test(value)) {

			return value;

		}

		if (right != null) {

			result = right.find(searcher);

		}

		return result;

	}

	public void toArray(Pair<K, V>[] array, AtomicInteger atomicInteger) {

		if (left != null) {

			left.toArray(array, atomicInteger);

		}

		array[atomicInteger.incrementAndGet()] = new Pair<K, V>(key, value);

		if (right != null) {

			right.toArray(array, atomicInteger);

		}
	}

	public int indexOf(K key, AtomicInteger atomicInteger) {

		int result;

		if (left != null) {

			result = left.indexOf(key, atomicInteger);

			if (result >= 0) {

				return result;

			}
		}

		if (key.equals(this.key)) {

			return atomicInteger.get();

		}

		atomicInteger.incrementAndGet();

		if (right != null) {

			return right.indexOf(key, atomicInteger);

		}

		return -1;

	}

	public Pair<K, V> getIndex(int index, AtomicInteger atomicInteger) {

		if (left != null) {

			Pair<K, V> result = left.getIndex(index, atomicInteger);

			if (result != null) {

				return result;

			}
		}

		if (atomicInteger.getAndIncrement() == index) {

			return new Pair<K, V>(key, value);

		}

		if (right != null) {

			return right.getIndex(index, atomicInteger);

		}

		return null;

	}

	public int findIndex(Predicate<V> searcher, AtomicInteger atomicInteger) {

		int result;

		if (left != null) {

			result = left.findIndex(searcher, atomicInteger);

			if (result >= 0) {

				return result;
			}
		}

		if (searcher.test(value)) {

			return atomicInteger.get(); 

		}

		atomicInteger.incrementAndGet();

		if (right != null) {

			return right.findIndex(searcher, atomicInteger);

		}

		return -1;

	}
}

