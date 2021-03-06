import controller.Controller;
import model.Model;
import view.GUIView;
import view.TextView;

public class App {

  /**
   * Starts the "Rock Paper Scissors" game either in a graphical or text-based user interface view.
   *
   * @param args contains one element that can be either "GUI" or "text" depending on the desired
   *     game mode.
   * @throws IllegalArgumentException thrown in case given argument is neither "GUI" or "text" or
   *     none argument is given.
   */
  public static void main(String[] args) throws IllegalArgumentException {

    Model model = new Model();
    Controller controller = new Controller(model);

    if (args.length == 0) {
      throw new IllegalArgumentException(
          "There should be one program argument that" + " can only be \"GUI\" or \"text\".");
    }

    if (args[0].compareTo("GUI") == 0) {
      new GUIView(model, controller);
    } else if (args[0].compareTo("text") == 0) {
      new TextView(model, controller);
    } else {
      throw new IllegalArgumentException("Program argument can only be \"GUI\"" + " or \"text\".");
    }
  }
}
