
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Malfunction {
  private Object issue = quotes.UNKNOWNQuote.getInstance();
  private String printer_id = "";
  private Boolean solved = false;

  public void cg_init_Malfunction_1(final Object i, final String s) {

    issue = i;
    printer_id = s;
    return;
  }

  public Malfunction(final Object i, final String s) {

    cg_init_Malfunction_1(i, s);
  }

  public void fix() {

    solved = true;
  }

  public Object get_issue() {

    return this.issue;
  }

  public String get_printer_id() {

    return this.printer_id;
  }

  public Boolean get_solved() {

    return this.solved;
  }

  public Malfunction() {}

  public String toString() {

    return "Malfunction{"
        + "issue := "
        + Utils.toString(issue)
        + ", printer_id := "
        + Utils.toString(printer_id)
        + ", solved := "
        + Utils.toString(solved)
        + "}";
  }
}
