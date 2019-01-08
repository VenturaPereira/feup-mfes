
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Employee {
  private String name = "Unnamed employee";

  public void cg_init_Employee_1(final String n) {

    name = n;
    return;
  }

  public Employee(final String n) {

    cg_init_Employee_1(n);
  }

  public String get_name() {

    return this.name;
  }

  public Employee() {}

  public String toString() {

    return "Employee{" + "name := " + Utils.toString(name) + "}";
  }
}
