
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class University {
  private Object name = quotes.FEUPQuote.getInstance();
  private VDMSet students = SetUtil.set();
  private VDMSet printers = SetUtil.set();

  public void cg_init_University_1(final Object n, final VDMSet s, final VDMSet p) {

    name = n;
    students = Utils.copy(s);
    printers = Utils.copy(p);
    return;
  }

  public University(final Object n, final VDMSet s, final VDMSet p) {

    cg_init_University_1(n, Utils.copy(s), Utils.copy(p));
  }

  public Object get_name() {

    return this.name;
  }

  public University() {}

  public String toString() {

    return "University{"
        + "name := "
        + Utils.toString(name)
        + ", students := "
        + Utils.toString(students)
        + ", printers := "
        + Utils.toString(printers)
        + "}";
  }
}
