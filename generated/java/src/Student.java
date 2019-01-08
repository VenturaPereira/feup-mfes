
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Student {
  private String id = "fe000000000";
  private Number balance = 0.0;
  private PrintingQueue queue = new PrintingQueue();

  public void cg_init_Student_1(final String idd) {

    id = idd;
    return;
  }

  public Student(final String idd) {

    cg_init_Student_1(idd);
  }

  public void add_balance(final Number value) {

    balance = balance.doubleValue() + value.doubleValue();
  }

  public void push_document(final Document document) {

    queue.push_document(document);
  }

  public void delete_document(final Document document) {

    queue.delete_document(document);
  }

  public void report_malfunction(final Service s, final Malfunction m) {

    s.push_issue(m);
  }

  public String get_id() {

    return this.id;
  }

  public Number get_balance() {

    return this.balance;
  }

  public VDMSeq get_queue() {

    return this.queue.get_documents();
  }

  public Student() {}

  public static Boolean assert_id_syntax(final String id_2) {

    Boolean andResult_25 = false;

    if (Utils.equals(id_2.length(), 11L)) {
      Boolean orResult_4 = false;

      if (has_substring("fe", id_2)) {
        orResult_4 = true;
      } else {
        Boolean orResult_5 = false;

        if (has_substring("fl", id_2)) {
          orResult_5 = true;
        } else {
          orResult_5 = has_substring("ic", id_2);
        }

        orResult_4 = orResult_5;
      }

      if (orResult_4) {
        andResult_25 = true;
      }
    }

    return andResult_25;
  }

  public static Boolean has_substring(final String s1, final String s2) {

    return Utils.equals(SetUtil.intersect(SeqUtil.elems(s1), SeqUtil.elems(s2)), SeqUtil.elems(s1));
  }

  public String toString() {

    return "Student{"
        + "id := "
        + Utils.toString(id)
        + ", balance := "
        + Utils.toString(balance)
        + ", queue := "
        + Utils.toString(queue)
        + "}";
  }
}
