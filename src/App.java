import list.io.Input;
import static list.io.Output.print;

import commands.Commands;

public class App {
  private static String  title = "🅛 🅘 🅢 🅣 🅐 🅢";
  private static Commands commands = new Commands();

  private static String message = commands.getMenu();

  public static void main(String[] args) throws Exception {
    print(title);
    
    while (true) {
      String command = Input.string(message);

      if(command.equals("0")) break;

      commands.executeCommand(command);

      Input.string("pressione qualquer tecla para continuar");
    }
  }
}
