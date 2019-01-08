
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EmployeeTests extends TestSuite {
  private Employee employee1 = new Employee("Miguel");
  private Employee employee2 = new Employee("Ventura");

  private void test_name_assignment() {

    University university1 =
        new University(
            quotes.FEUPQuote.getInstance(), SetUtil.set(new Student()), SetUtil.set(new Printer()));
    assert_true(Utils.equals(university1.get_name(), quotes.FEUPQuote.getInstance()));
    assert_true(Utils.equals(employee1.get_name(), "Miguel"));
    assert_true(Utils.equals(employee2.get_name(), "Ventura"));
  }

  public static void main() {

    EmployeeTests et = new EmployeeTests();
    et.test_name_assignment();
  }

  public EmployeeTests() {}

  public String toString() {

    return "EmployeeTests{"
        + "employee1 := "
        + Utils.toString(employee1)
        + ", employee2 := "
        + Utils.toString(employee2)
        + "}";
  }
}
