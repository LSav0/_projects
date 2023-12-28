package stackDataStructure;

public class StackImplementation<E> {

	private static final int DEFAULT_STACK_SIZE = 10; 
	private Object[] itemArray; 
	private int top = -1; 


	public StackImplementation() { 

		itemArray = new Object[DEFAULT_STACK_SIZE];
		top = -1;

	}

	public StackImplementation(int capacity) { 

		itemArray = new Object[capacity];
		top = -1;

	}

	public int capacity() {

		return itemArray.length; 

	}

	public void push(E element) throws OutOfMemoryError, NullPointerException {

		if (null == element) {

			throw new NullPointerException();

		}

		if (top == itemArray.length - 1) {

			reallocate(itemArray.length * 2);

		}

		top += 1;
		itemArray[top] = element;

	}

	@SuppressWarnings("unchecked")
	public E pop() throws IllegalStateException {

		if (isEmpty()) {

			throw new IllegalStateException();

		}

		Object temp = itemArray[top]; 

		itemArray[top] = null;
		top -= 1;

		return (E) temp;

	}

	@SuppressWarnings("unchecked")
	public E peek() throws IllegalStateException {

		if (top == -1) {

			throw new IllegalStateException();
		}

		return (E) itemArray[top];

	}

	public int size() {

		return top + 1;

	}

	public boolean isEmpty() {

		if (top == -1) {

			return true;
		}

		return false;
	}

	public void clear() {

		itemArray = new Object[DEFAULT_STACK_SIZE];
		top = -1;

	}

	private void reallocate(int newCapacity) throws OutOfMemoryError {

		Object[] temp = new Object[newCapacity]; 

		for (int index = 0; index <= top; index++) {

			temp[index] = itemArray[index]; 
		}

		itemArray = temp; 
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int index = 0;

		builder.append("[");

		while (index <= top) {

			builder.append(itemArray[index]);
			index++;

			if (index <= top) {

				builder.append(", ");

			}
		}

		builder.append("]");

		return builder.toString();
	}

	public static void main(String[] args) {

		StackImplementation<Integer> stack = new StackImplementation<>();

		
		stack.push(5);
		stack.push(10);
		stack.push(15);

		
		System.out.println("Peek: " + stack.peek());

		
		System.out.println("Popped: " + stack.pop());
		System.out.println("Popped: " + stack.pop());

	
		System.out.println("Size: " + stack.size());
		System.out.println("Is Empty: " + stack.isEmpty());

		
		stack.clear();
		System.out.println("Is Empty after clear: " + stack.isEmpty());
	}
}
