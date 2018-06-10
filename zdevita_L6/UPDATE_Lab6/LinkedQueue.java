import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Cloneable
{
   private int manyNodes;
   private Node<E> front;
   private Node<E> rear;
   
   /**
   * Initialize an empty queue.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This queue is empty.
   **/   
   public LinkedQueue( )
   {
      front = null;
      rear = null;
   }

   /**
   * Put a new a new item in this queue. 
   * @param <CODE>item</CODE>
   *   the item to be pushed onto this queue 
   * <dt><b>Postcondition:</b><dd>
   *   The item has been pushed onto this queue.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the queue's capacity.
   * <dt><b>Note:</b><dd>
   *   An attempt to increase the capacity beyond
   *   <CODE>Integer.MAX_VALUE</CODE> will cause the queue to fail with an
   *   arithmetic overflow.
   **/    
   public void add(E item)
   {
       if (isEmpty( ))
       {  // Insert first item.
	  front = new Node<E>(item, null);
	  rear = front;
       }
       else
       {  // Insert an item that is not the first.
          rear.addNodeAfter(item);
          rear = rear.getLink( );          
       }
       manyNodes++;
   }
              
   /**
   * Generate a copy of this queue.
   * @param - none
   * @return
   *   The return value is a copy of this queue. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>LinkedQueue</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public LinkedQueue<E> clone( )       
   {  // Clone a LinkedQueue<E>.
      LinkedQueue<E> answer;
      Node<E>[ ] cloneInfo;
      
      try
      {
         answer = (LinkedQueue<E>) super.clone( );
      }
      catch (CloneNotSupportedException e)
      { 
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      cloneInfo = Node.listCopyWithTail(front);
      answer.front = cloneInfo[0];
      answer.rear = cloneInfo[1];
      
      return answer;
   }        

   /**
   * Determine whether this queue is empty.
   * @param - none
   * @return
   *   <CODE>true</CODE> if this queue is empty;
   *   <CODE>false</CODE> otherwise. 
   **/
   public boolean isEmpty( )
   {
      return (manyNodes == 0);
   }

   public E peek()
   {
	   E answer = front.getData();
	   return answer;
   }
   
   /**
   * Get the front item, removing it from this queue.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   This queue is not empty.
   * <dt><b>Postcondition:</b><dd>
   *   The return value is the front item of this queue, and the item has
   *   been removed.
   * @exception NoSuchElementException
   *   Indicates that this queue is empty.
   **/    
   public E remove()
   {
      E answer;

      if (manyNodes == 0)
         // NoSuchElementException is from java.util and its constructor has no argument.
         throw new NoSuchElementException("Queue underflow");
      answer = front.getData( );
      front = front.getLink( );
      manyNodes--;
      if (manyNodes == 0)
         rear = null;
      return answer;
   }
   
   /**
   * Accessor method to determine the number of items in this queue.
   * @param - none
   * @return
   *   the number of items in this queue
   **/ 
   public int size()   
   {
      return manyNodes;
   }
}
