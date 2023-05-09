package list;

public class List {
  private Node<Integer> head;
  private Node<Integer> tail;

  public List(int value) {
    this.head = new Node<Integer>(value);
    this.tail = head;
  }

  // ------------------------------------------------------------------------ //

  public void insert(Integer value) {
    Node<Integer> node = new Node<Integer>(value);
    Node<Integer> current = this.head;
    Node<Integer> next = null;
    Node<Integer> previous = null;

    while(value > current.getValue()) {
      next = current.getNext();

      if (next == null) break;

      previous = current;
      current = next;
    }

    node.setNext(next);
    node.setPrevious(previous);

    if (previous != null) previous.setNext(node);
    else this.head = node;
    
    if (next != null) next.setPrevious(node);
    else this.tail = node;
  }

  public void list() {
    Node<Integer> node = head;

    while(true) {
      System.out.println(node.getValue());

      if (node.getNext() == null) break;

      node = node.getNext();
    }
  }
}
