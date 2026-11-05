public class RefStack<T> { 

   private Node<T> head;
   private int numOfElements;
   
  public T peek() {
      if(isEmpty())
      return null;

   return head.getData();
   }

    public void push(T data) {
      if(data == null) {
         throw new IllegalArgumentException("Data can't be null");
         }

      Node<T> newNode = new Node<>(data);
         if (head == null) 
            head = newNode;
         else {
            newNode.setNext(head);
            head = newNode;
        }
        numOfElements++;
    }

    public T pop() throws MyEmptyStackException {
        if(isEmpty())
            throw new MyEmptyStackException("Stack is empty");

        Node<T> popItem = head;
        head = head.getNext();
        numOfElements--;
        return popItem.getData();
        
    }
}