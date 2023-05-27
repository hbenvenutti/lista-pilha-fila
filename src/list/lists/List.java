package list.lists;

import static list.io.Output.print;

public class List {
  private Node<Integer> head = null;
  private Node<Integer> tail = null;

  public List() {};

  public List(int value) {
    this.head = new Node<Integer>(value);
    this.tail = head;
  }

  // ------------------------------------------------------------------------ //

  public void insert(Integer value) {
    Node<Integer> node = new Node<Integer>(value);
    Node<Integer> current = this.head;

    if (head == null) {head = node; return;}

    while (current.getNext() != null) {
      current = current.getNext();
    }

    current.setNext(node);
    node.setPrevious(current);

    list();

    return;
  }

  public boolean remove(int value) {
    Node<Integer> current = this.head;
    Node<Integer> next = null;
    Node<Integer> previous = null;
    boolean isValueInList = false;

    if (head == null) {
      print("lista vazia!"); 
      return false;
    }

    do {
      if (current.getValue() == value) { 
        isValueInList = true; 
        break; 
      };

      current = current.getNext();

    } while (current != null);

    
    if (!isValueInList) return false;

    if (current == head) head = head.getNext();

    previous = current.getPrevious();
    next = current.getNext();
    
    // if is needed for header removal
    if (previous != null) previous.setNext(next);
    
    // if is needed for tail removal
    if (next != null) next.setPrevious(previous);

    list();
    return true;
  }

  public void list() {
    print("list: \n[");

    Node<Integer> node = head;

    while(true) {
      print("\t" + node.getValue().toString() + ",");

      if (node.getNext() == null) break;

      node = node.getNext();
    }

    print("]");

    return;
  }
}
