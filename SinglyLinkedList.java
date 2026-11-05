public class SinglyLinkedList<E> { 

    private Node<E> head;
    private int numOfElements; 
    
    public SinglyLinkedList() {
      head = null;
      numOfElements = 0;
    }
    
    public boolean search(E key) {
      Node current = head;
      
      while (current != null) {
         if (current.data.equals(key)) {
            return true;
            }
      current = current.next;
      }

    return false;
    }
    
    public E get(int index) {
      if (head == null) { 
         throw new IllegalArgumentException("List is null");
         }
         
      if (index > numOfElements - 1) {
         throw new IllegalArgumentException("Index out of bounds");
         }
         
      int num = 0;
      Node current = head;
      
      while (num < index) {
         current = current.next;
         num ++;
      }
      return current.data; 
    }
    
    public void add(E element) {
      Node newNode = new Node(element);

      if (head == null) {
        head = newNode;
        return;
         }

    Node current = head;
    while (current.next != null) {
        current = current.next;
      }
    current.next = newNode;
    }
    
    
    public void remove(E element) throws IllegalArgumentException {
       if (element == null) 
            throw new IllegalArgumentException("Element cannot be null");
        
        Node<E> current = leadNode;
        Node<E> prevNode = null;
        while (current != null){
            if(current.getItem().equals(element)){
                if(prevNode != null)
                    prevNode.setNext(current.getNext());
                else 
                    leadNode = current.getNext();  
                return;
            }
            prevNode = current;
            current = current.getNext();
             
        }
   }
        
   public boolean searchRecursive(E key) {
      return searchHelper(head, key);
      }

   private boolean searchHelper(Node<E> current, E key) {
      if (current == null) {
         return false;
         }

      if (current.data.equals(key)) {
        return true;
        }

      return searchHelper(current.next, key);
   }
   
   public void addRecursive(E element) {
      head = addHelper(head, element);
      }

   private Node<E> addHelper(Node<E> current, E element) {
      if (current == null) {
         return new Node(element);
         }
      current.next = addHelper(current.next, element);
      return current;
   }
   
   public void removeRecursive(E element) {
    head = removeHelper(head, element);
}

private Node<E> removeHelper(Node<E> current, E element) {
    if (current == null) {
        return null;
         }

    if (current.data.equals(element)) {
        return current.next;
         }

    current.next = removeHelper(current.next, element);

    return current;
   }
   
   public E getRecursive(int index) {
    if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }

    return getHelper(head, index);
    }

   private E getHelper(Node current, int index) {
      if (index == 0) {
        return current.data;
         }

    return getHelper(current.next, index - 1);
    }
    
}