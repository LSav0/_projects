package algorithmsS;


public class Algorithms {


	private Algorithms() {


	}

	public static <T> void swap(T[] array, int first, int second) {

		T temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	public static <T extends Comparable<T>> void insertionSort(T[] array) {

		insertionSort(array, 0, array.length);

	}

	public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {

		for (int i = fromIndex + 1; i < toIndex; i++) {

			T temp = array[i];
			int j = i - 1;

			while (j >= 0 && array[j].compareTo(temp) > 0) {

				array[j + 1] = array[j];
				j--;

			}

			array[j + 1] = temp;

		}

	}

	public static <T> void reverse(T[] array) {

		reverse(array, 0, array.length);

	}

	public static <T> void reverse(T[] array, int fromIndex, int toIndex) {

		int first = fromIndex;
		int last = toIndex - 1;

		do {

			swap(array, first, last);
			first++;
			last--;

		} while (first < last);

	}

	private static <E extends Comparable<E>> int partitionComparable(E[] array, int fromIndex, int toIndex) {

		E pivot = array[fromIndex + (toIndex - fromIndex) / 2];

		int leftIndex = fromIndex - 1;
		int rightIndex = toIndex + 1;

		while (true) {

			do {

				leftIndex++;

			} while (array[leftIndex].compareTo(pivot) < 0);

			do {

				rightIndex--;

			} while (array[rightIndex].compareTo(pivot) > 0);

			if (leftIndex >= rightIndex) {

				return rightIndex;

			}

			swap(array, leftIndex, rightIndex);

		}
	}

	public static <E extends Comparable<E>> void fastSort(E[] array) {

		quickSort(array, 0, array.length - 1);

	}

	public static <E extends Comparable<E>> void quickSort(E[] array, int fromIndex, int toIndex) {

		if (fromIndex >= 0 && toIndex >= 0 && fromIndex < toIndex) {

			int partitionIndex = partitionComparable(array, fromIndex, toIndex);

			quickSort(array, fromIndex, partitionIndex);
			quickSort(array, partitionIndex + 1, toIndex);

		}
	}
	
	public static <T extends Comparable<T>> void heapsort(T[] myArray, int length) {

		heapify(myArray, length);

		int end = length - 1;

		while(end > 0) {

			swap(myArray, end, 0);

			end--; 

			siftDown(myArray, 0, end); 

		}  
	}

	public static <T extends Comparable<T>> void  heapify(T[] myArray, int count){

		int start = parent(count - 1); 

		while(start >= 0) {
			siftDown(myArray, start, count - 1); 
			start--;
		}
	  }
	

	public static <T extends Comparable<T>> void siftDown(T[] myArray, int start, int end) {

		int root = start;

		while (leftChild(root) <= end) { 

			int child = leftChild(root); 

			int swap = root; 

			if (myArray[swap].compareTo(myArray[child]) < 0) {

				swap = child;
			}

			if (child + 1 <= end && myArray[swap].compareTo(myArray[child + 1]) < 0) { 

				swap = child + 1;
			}

			if (swap == root) { 

				return; 

			}
			else {

				swap(myArray, root, swap);
				root = swap;
			}
		}
	}
	
	private static int parent(int index) {

		return (index - 1)/ 2;
	}		


	private static int leftChild(int index) {

		return 2 * index + 1;
	}


}
