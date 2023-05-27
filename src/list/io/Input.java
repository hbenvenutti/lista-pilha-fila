package list.io;

import java.util.Scanner;
import static list.io.Output.print;
import static list.io.Output.printError;;

public class Input {
  private static Scanner scanner = new Scanner(System.in);

  public static String string(String message) {
    print(message);
    return scanner.nextLine();
  }

  public static int integer(String message) {
    print(message);
    String input = scanner.nextLine();

    try {
      int value = Integer.parseInt(input);
      return Math.abs(value);

    } catch (Exception e) {
      printError("O valor inserido não é válido!");
      return -1;
    }
  }
}
