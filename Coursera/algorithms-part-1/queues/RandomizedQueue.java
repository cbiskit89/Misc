import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N = 0;
    
    public RandomizedQueue() {
        // construct an empty randomized queue
        q = (Item[]) new Object[1];
    }
    
    public boolean isEmpty() {
        // is the queue empty?
        return N == 0;
    }
    
    public int size() {
        // return the number of items on the queue
        return N;
    }
    
    public void enqueue(Item item) {
        // add the item
        if (item == null) { throw new java.lang.NullPointerException("You cannot add a null item."); }
        if (N == q.length) { resize(2 * q.length); }
        boolean added = false;
        while (added) {
            int rand = StdRandom.uniform(N);
            if (q[rand] == null) { 
                q[rand] = item;
                added = true;
            }
        }
        N++;
    }
    
    public Item dequeue() {
        // remove and return a random item
        if (N == 0) { throw new java.util.NoSuchElementException("You cannot dequeue from an empty queue."); }
        int rand = StdRandom.uniform(N);
        Item item = q[rand];
        q[rand] = null;
        if (N == (q.length / 4)) { resize(q.length); }
        return item;
    }
    
    public Item sample() {
        // return (but do not remove) a random item
        if (N == 0) { throw new java.util.NoSuchElementException("You cannot dequeue from an empty queue."); }
        int rand = StdRandom.uniform(N);
        Item item = q[rand];
        q[rand] = null;
        return item;
    }
    
    private void resize(int capacity) {
        Item[] newQ = (Item[]) new Object[capacity];
        for (int i = 0; i < q.length; i++) {
            int j = 0;
            if (q[i] != null) {
                newQ[j] = q[i];
                j++;
            }
        }
        q = newQ;
    }
    
    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i = N;
        private Item[] it;
        
        RandomizedQueueIterator() {
            it = (Item[]) new Object[i];
            for (int j = 0; j < i; j++) {
                it[j] = q[j];
            }
            
            StdRandom.shuffle(it);
        }
        
        public boolean hasNext() {
            return i > 0;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("You cannot call the Iterator remove() function.");
        }
        
        public Item next() {
            if (!hasNext()) { throw new java.util.NoSuchElementException("There is not a next item."); }
            Item item = it[--i];
            it[i] = null;
            return item;
        }
    }
    
    public static void main(String[] args) {
        // unit testing
    }
}