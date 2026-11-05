public class ArrStack {

   private T[] arr;
   private int top;
   private int numOfElements;
   private int maxCapacity;
   
  public void push(T item) {
      if(top == maxCapacity - 1) 
         copyArray();

        top++;
        arr[top] = item;
        numOfElements++;
   }
   
   public T pop() throws MyEmptyStackException {
      if(isEmpty())
         throw new MyEmptyStackException("The stack is empty");

        T temp = arr[top];
        top--;
        numOfElements--;
        return temp;
    }
 
    public T peek() throws MyEmptyStackException{
      if(isEmpty())
         throw new MyEmptyStackException("The stack is empty");

      return arr[top];
    }
  
}