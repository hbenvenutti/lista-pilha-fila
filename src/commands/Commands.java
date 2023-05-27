package commands;
import list.io.Input;
import list.lists.List;
import list.lists.Queue;
import list.lists.Stack;
import static list.io.Output.print;
import static list.io.Output.printError;

import java.util.HashMap;
import java.util.Map;


public class Commands {
  private List list;
  private Stack<Integer> stack;
  private Queue<Integer> queue;
  private String menu = ""
  + "1 - Criar uma lista;\n"
  + "2 - Criar uma pilha;\n"
  + "3 - Criar uma fila;\n"
  + "4 - Inserir na lista;\n"
  + "5 - Inserir na pilha;\n"
  + "6 - Inserir na fila;\n"
  + "7 - Remover da lista;\n"
  + "8 - Remover da pilha;\n"
  + "9 - Remover da fila;\n"
  + "0 - Encerrar programa.";

  private Map<String, Runnable> map = new HashMap<String, Runnable>() {{
    this.put("1", () -> createList());
    this.put("2", () -> createStack());
    this.put("3", () -> createQueue());
    this.put("4", () -> insertIntoList());
    this.put("5", () -> insertIntoStack());
    this.put("6", () -> insertIntoQueue());
    this.put("7", () -> removeFromList());
    this.put("8", () -> popStack());
    this.put("9", () -> popQueue());
  }};

  public void createList(){
    int value = Input
      .integer("digite um número inteiro para inicializar a lista: ");

    this.list = new List(value);

    list.list();
    return;
  }

  public void createStack() {
    int value = Input
      .integer("digite um número inteiro para inicializar a pilha: ");

    this.stack = new Stack<Integer>(value);

    stack.list();
    return;
  }

  public void createQueue() {
    int value = Input
      .integer("digite um número inteiro para inicializar a fila: ");

    this.queue = new Queue<Integer>(value);

    queue.list();
    
    return;
  }

  public void insertIntoList() {
    int value = Input
      .integer("digite um número inteiro para inserir: ");

    list.insert(value);

    list.list();
    return;
  }

  public void insertIntoStack() {
    int value = Input
      .integer("digite um número inteiro para inserir: ");

    stack.push(value);

    stack.list();
    return;
  }

  public void insertIntoQueue() {
    int value = Input
      .integer("digite um número inteiro para inserir: ");

    queue.push(value);

    queue.list();
    return;
  }

  public void removeFromList() {
    int value = Input.integer("digite o valor a ser removido: ");
    boolean wasRemoved = list.remove(value);

    if (!wasRemoved) printError("valor não removido!");

    print("O valor " + value + " foi removido com sucesso!");
  }

  public int popStack() {
    int value = stack.pop();
    print("removido " + value + " da pilha.");
    return value;
  }

  public int popQueue() {
    int value = queue.pop();
    print("removido " + value + " da fila.");
    return value;
  }

  private boolean isCommandValid(String command) {
    Runnable value = this.map.get(command);
    
    if (value != null) return true;

    printError("Comando inválido!");

    return false;
  }

  public void executeCommand(String command) {
    if (!isCommandValid(command)) return;

    this.map.get(command).run();

    return;
  }
  
  public String getMenu() {
    return this.menu;
  }

}
