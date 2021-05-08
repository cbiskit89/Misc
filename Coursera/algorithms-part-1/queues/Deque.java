import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int N;
    
    private class Node {
        Item item;
        Node next;
        Node previous;
    }
    
    public Deque() {
        // construct an empty deque
        first = new Node();
        first = null;
        last = first;
        N = 0;
    }
    
    public boolean isEmpty() {
        // is the deque empty?
        return N == 0;
    }
    
    public int size() {
        // return the number of items on the deque
        return N;
    }
    
    public void addFirst(Item item) {
        // add the item to the front
        checkNullBeforeAdd(item);
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.previous = null;
        if (isEmpty()) { 
            last = first;
        }
        else {
            oldfirst.previous = first;
            first.next = oldfirst;
        }
        N++;
    }
    
    public void addLast(Item item) {
        // add the item to the end
        checkNullBeforeAdd(item);
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        N++;
    }
    
    public Item removeFirst() {
        // remove and return the item from the front
        checkEmptyBeforeRemove();
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = first;
        }
        else {
            first.previous = null;
        }
        return item;
    }
    
    public Item removeLast() {
        // remove and return the item from the end
        checkEmptyBeforeRemove();
        Item item = last.item;
        last = last.previous;
        N--;
        if (isEmpty()) {
            first = last;
        }
        else {
            last.next = null;
        }
        return item;
    }
    
    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("You cannot call the Iterator remove() function.");
        }
        
        public Item next() {
            if (!hasNext()) { throw new java.util.NoSuchElementException("There is not a next item."); }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    private void checkNullBeforeAdd(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("You cannot add a null item.");
        }
    }
    
    private void checkEmptyBeforeRemove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("You cannot remove an item because the deque is empty.");
        }
    }
    public static void main(String[] args) {
        // unit testing
    }
}