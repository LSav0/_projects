package queueDataStructure;

public class QueueImplementation<E> {

	  private static int DEFAULT_QUEUE_SIZE = 10; 
	    private Object[] itemArray; 
	    private int count = 0; 
	    private int tail = 0; 
	    private int head = 0; 

	    public QueueImplementation() {

	        itemArray = new Object[DEFAULT_QUEUE_SIZE];
	        count = 0;
	        tail = 0;
	        head = 0;

	    }

	    public QueueImplementation(int capacity) {

	        itemArray = new Object[capacity];
	        count = 0;
	        tail = 0;
	        head = 0;

	    }

	  
	    public int capacity() {

	        return itemArray.length;

	    }

	   
	    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {

	        if (null == element) {

	            throw new NullPointerException();

	        }

	        if (count == itemArray.length) { 

	            reallocate(2 * itemArray.length);
	        }
	       
	        if (tail >= itemArray.length && head > 0) { 
	               
	            tail = 0;

	        }

	        itemArray[tail++] = element;
	        count++;
	    }

	    @SuppressWarnings("unchecked")
	    public E dequeue() throws IllegalStateException {

	        if (count == 0) {

	            throw new IllegalStateException();

	        }

	        Object temp = itemArray[head];
	        itemArray[head] = null;

	        head++;
	        count--;

	        if (head >= itemArray.length) {
	           
	            head = 0;

	        }

	        return (E) temp;

	    }

	    @SuppressWarnings("unchecked")
	    public E element() throws IllegalStateException {

	        if (isEmpty()) {

	            throw new IllegalStateException();

	        }

	        return (E) itemArray[head];

	    }

	  
	    public int size() {

	        return count;

	    }

	    
	    public boolean isEmpty() {

	        if (count == 0) {

	            return true;

	        }

	        return false;

	    }

	  
	    public void clear() {

	        itemArray = new Object[DEFAULT_QUEUE_SIZE];
	        head = 0;
	        tail = 0;
	        count = 0;

	    }

	    private void reallocate(int newCapacity) throws OutOfMemoryError {

	        Object[] temp = new Object[newCapacity];

	        int oldIndex = head;
	        int newIndex = 0;
	        int counter = count;

	        while (counter > 0) {

	           counter--;

	            if (oldIndex >= itemArray.length) {

	                oldIndex = 0;

	            }

	            temp[newIndex] = itemArray[oldIndex];
	            newIndex++;
	            oldIndex++;

	        }

	        head = 0;
	        tail = count;

	        itemArray = temp;

	    }

	    @Override
	    public String toString() {

	        StringBuilder builder = new StringBuilder();

	        int counter = count;
	        int index = head;

	        builder.append("[");

	        while (counter > 0) {

	            builder.append(itemArray[index]);

	            if (counter > 1) {

	                builder.append(", ");

	            }

	            index++;
	            counter--;

	            if (index >= itemArray.length) {

	                index = 0;
	            }
	          }

	        builder.append("]");

	        return builder.toString();

	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

       QueueImplementation<String> stringQueue = new QueueImplementation<>();
		
		
		stringQueue.enqueue("first");
		stringQueue.enqueue("second");
		stringQueue.enqueue("third");
		stringQueue.enqueue("fourth");
		
		System.out.println(stringQueue.toString());
		
		QueueImplementation<Integer> intQueue = new QueueImplementation<>();
		
		
		int counter = 10;
		
		while(counter > 0) {
				
			intQueue.enqueue(counter);
			counter--;
			
		}
		
		System.out.println(intQueue.toString());
		
		intQueue.dequeue();
		intQueue.dequeue();
		intQueue.dequeue();
	
		System.out.println(intQueue.toString());
	}

}
