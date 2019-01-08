
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MalfunctionTests extends TestSuite {
  private Service service1 = new Service();
  private Employee employee1 = new Employee("A");
  private Employee employee2 = new Employee("B");
  private Employee employee3 = new Employee("C");
  private Student student1 = new Student("fe201503538");
  private Printer printer1 = new Printer(quotes.FEUPQuote.getInstance());
  private Printer printer2 = new Printer(quotes.FEUPQuote.getInstance());

  private void test_employee_addition() {

    service1.add_employee(employee1);
    service1.add_employee(employee2);
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(new Maplet(employee1, null), new Maplet(employee2, null))));
    service1.add_employee(employee3);
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(
                new Maplet(employee1, null),
                new Maplet(employee2, null),
                new Maplet(employee3, null))));
    service1.remove_employee(employee2);
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(new Maplet(employee1, null), new Maplet(employee3, null))));
    assert_true(Utils.equals(service1.get_employees(), SetUtil.set(employee1, employee3)));
  }

  private void test_malfunction_assignment() {

    Malfunction malfunction1 =
        new Malfunction(quotes.NO_PAPERQuote.getInstance(), printer1.get_id());
    Malfunction malfunction2 = new Malfunction(quotes.NO_BLKQuote.getInstance(), printer1.get_id());
    Malfunction malfunction3 = new Malfunction(quotes.NO_CMYQuote.getInstance(), printer2.get_id());
    student1.report_malfunction(service1, malfunction1);
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(new Maplet(employee1, malfunction1), new Maplet(employee3, null))));
    service1.fix_all_issues();
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(new Maplet(employee1, null), new Maplet(employee3, null))));
    student1.report_malfunction(service1, malfunction2);
    service1.add_employee(employee2);
    student1.report_malfunction(service1, malfunction3);
    assert_true(
        Utils.equals(
            service1.get_assigned(),
            MapUtil.map(
                new Maplet(employee1, malfunction2),
                new Maplet(employee3, null),
                new Maplet(employee2, malfunction3))));
  }

  private void test_malfunction_solved() {

    Malfunction malfunction4 =
        new Malfunction(quotes.NO_PAPERQuote.getInstance(), printer1.get_id());
    student1.report_malfunction(service1, malfunction4);
    assert_true(Utils.equals(malfunction4.get_solved(), false));
    service1.fix_all_issues();
    assert_true(Utils.equals(malfunction4.get_solved(), true));
  }

  private void test_malfunction_getters() {

    Malfunction malfunction5 = new Malfunction(quotes.NO_BLKQuote.getInstance(), printer1.get_id());
    assert_true(Utils.equals(malfunction5.get_issue(), quotes.NO_BLKQuote.getInstance()));
    assert_true(Utils.equals(malfunction5.get_printer_id(), printer1.get_id()));
  }

  public static void main() {

    MalfunctionTests mt = new MalfunctionTests();
    mt.test_employee_addition();
    mt.test_malfunction_assignment();
    mt.test_malfunction_solved();
    mt.test_malfunction_getters();
  }

  public MalfunctionTests() {}

  public String toString() {

    return "MalfunctionTests{"
        + "service1 := "
        + Utils.toString(service1)
        + ", employee1 := "
        + Utils.toString(employee1)
        + ", employee2 := "
        + Utils.toString(employee2)
        + ", employee3 := "
        + Utils.toString(employee3)
        + ", student1 := "
        + Utils.toString(student1)
        + ", printer1 := "
        + Utils.toString(printer1)
        + ", printer2 := "
        + Utils.toString(printer2)
        + "}";
  }
}
