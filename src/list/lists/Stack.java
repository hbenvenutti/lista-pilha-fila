package list.lists;

import static list.io.Output.print;

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

    list();
    return value;
  }

  public void list() {
    Node<T> node = head;

    print("stack: \n[");

    while(true) {
      print("\t" + node.getValue().toString() + ",");

      if (node.getNext() == null) break;

      node = node.getNext();
    }

    print("]");
  }
}
