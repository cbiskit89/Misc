package blaCircular;


public class CircularArrayQueue
{
  private final int DEFAULT_CAPACITY = 100;
  private int front, rear, count;
  private int [] queue; 
  
  /**
   * Creates an empty queue using the default capacity.
   */
  public CircularArrayQueue()
  {
    front = rear = count = 0;
    queue = new int[DEFAULT_CAPACITY];
  }
  
  /**
   * Creates an empty queue using the specified capacity.
   * 
   * @param initialCapacity  the integer representation of the initial
   *                         size of the circular array queue
   */
  public CircularArrayQueue (int initialCapacity)
  {
    front = rear = count = 0;
    queue = new int[initialCapacity];
  }
  
  /**
   * Adds the specified element to the rear of this queue, expanding
   * the capacity of the queue array if necessary.
   * 
   * @param element  the element to add to the rear of the queue
   */
  public void enqueue (int element)
  {
    if (size() == queue.length) 
        expandCapacity();
    
    queue[rear] = element;
    rear = (rear+1) % queue.length;
    
    count++;
  }
  
  /**
   * Removes the element at the front of this queue and returns a
   * reference to it. Throws an EmptyCollectionException if the
   * queue is empty.
   *
   * @return                           the reference to the element at the front
   *                                   of the queue that was removed
   * @throws EmptyCollectionException  if an empty collections exception occurs
   */
  public int dequeue()
  {
    if (isEmpty())
        throw new RuntimeException("Queue underflow");
    
    int result = queue[front];

    front = (front+1) % queue.length;
    
    count--;
    
    return result;
  }
  
  /**
   * Returns a reference to the element at the front of this queue.
   * The element is not removed from the queue.  Throws an
   * EmptyCollectionException if the queue is empty.
   *
   * @return                           a reference to the first element in the 
   *                                   queue
   * @throws EmptyCollectionException  if an empty collections exception occurs
   */
  public int first() 
  {
    if (isEmpty())
        throw new RuntimeException("Queue underflow");
    
    return queue[front];
  }
  
  /**
   * Returns true if this queue is empty and false otherwise.
   * 
   * @return  returns true if this queue is empty and false if otherwise
   */
  public boolean isEmpty()
  {
    return (count == 0);
  }
  
  /**
   * Returns the number of elements currently in this queue.
   * 
   * @return  the integer representation of the size of this queue
   */
  public int size()
  {
    return count;
  }
  
  /**
   * Returns a string representation of this queue. 
   *
   * @return  the string representation of this queue
   */
  public String toString()
  {
    String result = "";
    int scan = 0;
    
    if (count > 0)
    while(scan < count)
    {
     
        result += queue[scan]+ "\n";
        scan++;
    }
    
    return result;
  }

  /**
   * Creates a new array to store the contents of this queue with
   * twice the capacity of the old one.
   */
  public void expandCapacity()
  {
    int [] larger = new int[queue.length *2];
    
    for(int scan=0; scan < count; scan++)
    {
      larger[scan] = queue[front];
      front=(front+1) % queue.length;
    }
    
    front = 0;
    rear = count;
    queue = larger;
  }
}

