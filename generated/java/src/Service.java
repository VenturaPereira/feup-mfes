
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Service {
  private VDMSet employees = SetUtil.set();
  private VDMSet universities = SetUtil.set();
  private VDMMap assigned = MapUtil.map();

  public void add_employee(final Employee e) {

    employees = SetUtil.union(Utils.copy(employees), SetUtil.set(e));
    assigned = MapUtil.override(Utils.copy(assigned), MapUtil.map(new Maplet(e, null)));
  }

  public void remove_employee(final Employee e) {

    employees = SetUtil.diff(Utils.copy(employees), SetUtil.set(e));
    assigned = MapUtil.domResBy(SetUtil.set(e), Utils.copy(assigned));
  }

  public void push_issue(final Malfunction m) {

    Boolean logged = false;
    for (Iterator iterator_5 = MapUtil.dom(Utils.copy(assigned)).iterator();
        iterator_5.hasNext();
        ) {
      Employee emp = (Employee) iterator_5.next();
      Boolean andResult_23 = false;

      if (Utils.equals(((Malfunction) Utils.get(assigned, emp)), null)) {
        if (!(logged)) {
          andResult_23 = true;
        }
      }

      if (andResult_23) {
        assigned = MapUtil.override(Utils.copy(assigned), MapUtil.map(new Maplet(emp, m)));
        logged = true;
      }
    }
  }

  public void fix_all_issues() {

    for (Iterator iterator_6 = MapUtil.dom(Utils.copy(assigned)).iterator();
        iterator_6.hasNext();
        ) {
      Employee emp = (Employee) iterator_6.next();
      if (!(Utils.equals(((Malfunction) Utils.get(assigned, emp)), null))) {
        ((Malfunction) Utils.get(assigned, emp)).fix();
        assigned = MapUtil.override(Utils.copy(assigned), MapUtil.map(new Maplet(emp, null)));
      }
    }
  }

  public VDMSet get_employees() {

    return this.employees;
  }

  public VDMMap get_assigned() {

    return this.assigned;
  }

  public Service() {}

  public String toString() {

    return "Service{"
        + "employees := "
        + Utils.toString(employees)
        + ", universities := "
        + Utils.toString(universities)
        + ", assigned := "
        + Utils.toString(assigned)
        + "}";
  }
}
