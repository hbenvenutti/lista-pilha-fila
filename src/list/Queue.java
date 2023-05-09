package list;

public class Queue<T> {
  private Node<T> head;
  private Node<T> tail;
  
  public Queue(T value) {
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
    T value = this.head.getValue();
    Node<T> next = this.head.getNext();

    if (next != null) next.setPrevious(null);

    this.head = next;
    
    return value;
  }
}
