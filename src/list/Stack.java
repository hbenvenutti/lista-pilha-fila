package list;

public class Stack<T> {
  private Node<T> head;
  private Node<T> tail;
  
  public Stack(T value) {
    this.head = new Node<T>(value);
    this.tail = head;
  }  

  public void push(T value) {
    Node<T> node = new Node<T>(value);

    this.tail.setNext(node);
    node.setPrevious(this.tail);
    this.tail = node;
  }

  public T pop() {
    T value = this.tail.getValue();
    Node<T> previous = this.tail.getPrevious();

    previous.setNext(null);
    this.tail = previous;

    return value;
  }

  public void list() {
    Node<T> node = head;

    while(true) {
      System.out.println(node.getValue());

      if (node.getNext() == null) break;

      node = node.getNext();
    }
  }
}
