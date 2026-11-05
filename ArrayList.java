public class ArrayList<E> { 

   private E[] arr;
   private int numOfElements;
   private int capacity = 10;
   
   public ArrayList() {
         arr = (E[]) new Object[capacity];
         numOfElements = 0;
       }
       
   public boolean search (E element) {
      for (int i = 0; i < numOfElements; i++) {
        if (arr[i].equals(element)) {
            return true;
            }
      }

    return false;
   }
   
   public void add (E element) {
        if(element == null) {
            throw new NullPointerException("Element can't be null");
        }

        if(isFull()) {
            ensureCapacity();
        }

        arr[numOfElements] = element;
        numOfElements++;
   }

   public E remove(int index) {
    
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("Index is out of range");

        E temp = arr[index];

        for(int i = index; i < numOfElements - 1; i++)
            arr[i] = arr[i+1];
        
        arr[numOfElements - 1] = null;
        numOfElements--;
        return temp;
    }

   public E get (E element)  {
      if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("Index is out of range");
        return arr[index];
   }
   

}