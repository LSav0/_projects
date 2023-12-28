package bstTest;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class BinarySearchTree <K extends Comparable<K>, V>{

    TreeNode<K, V> root; 
    int size = 0; 
    private Comparator<K> comparator; 
    
                                    

    public BinarySearchTree (Comparator<K> comparator) {

        this.comparator = comparator;

    }

 
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException { 

        if (root == null) {

            root = new TreeNode<K, V>(key, value, comparator); 
            size++; 
            

        } else {

          
            if (root.insert(key, value)) { 
            size++;
           
            }
       }

    }

    public V get(K key) throws IllegalArgumentException {

        if (root == null) {

            return null;
        }

        return root.find(key);

    }

  
    public V find(Predicate<V> searcher) {

        if (root == null) {

            return null;
        }

        return root.find(searcher);

    }

    
    public int size() { 

        return size;

    }

   
    public void clear() { 

        size = 0;
        root = null;
    
    }

    @SuppressWarnings("unchecked")
    public Pair<K, V>[] toArray() throws Exception {

        Pair<K, V> array[] = new Pair[size];

        if (root == null) {

            return array;

        }

        AtomicInteger atomicInteger = new AtomicInteger(-1);

        root.toArray(array, atomicInteger);

        return array;

    }

   
    public int indexOf(K itemKey) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        if (root == null) {

            return -1;
        }

        return root.indexOf(itemKey, atomicInteger);

    }


    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {

      AtomicInteger atomicInteger = new AtomicInteger(0);

        if (index < 0 || index >= size) {

          throw new IndexOutOfBoundsException();

        }

        return root.getIndex(index, atomicInteger);
    }

    public int findIndex(Predicate<V> searcher) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        if (root == null) {

           return -1;
        }

        return root.findIndex(searcher, atomicInteger);

    }

    
}   
