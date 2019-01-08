
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PrinterTests extends TestSuite {
  private Student student1 = new Student("fe201503538");
  private Student student2 = new Student("ic201793252");
  private Document document1 =
      new Document("d1", 20L, quotes.BWQuote.getInstance(), quotes.A4Quote.getInstance());
  private Document document2 =
      new Document("d2", 40L, quotes.COLORQuote.getInstance(), quotes.A4Quote.getInstance());
  private Document document3 =
      new Document("d3", 60L, quotes.COLORQuote.getInstance(), quotes.A3Quote.getInstance());

  private void test_printer_id() {

    Printer printer1 = new Printer(quotes.FEUPQuote.getInstance());
    Printer printer2 = new Printer(quotes.FEUPQuote.getInstance());
    Printer printer3 = new Printer(quotes.ICBASQuote.getInstance());
    Printer printer4 = new Printer(quotes.FLUPQuote.getInstance());
    Printer printer5 = new Printer(quotes.FEUPQuote.getInstance());
    assert_true(Utils.equals(printer1.get_id(), "fe0000"));
    assert_true(Utils.equals(printer2.get_id(), "fe0001"));
    assert_true(Utils.equals(printer3.get_id(), "ic0000"));
    assert_true(Utils.equals(printer4.get_id(), "fl0000"));
    assert_true(Utils.equals(printer5.get_id(), "fe0002"));
    assert_true(Utils.equals(document1.get_title(), "d1"));
  }

  private void test_student_authentication() {

    Printer printer1 = new Printer(quotes.FEUPQuote.getInstance());
    printer1.auth(student1);
    assert_true(Utils.equals(printer1.get_auth_student(), student1));
    printer1.auth(student2);
    assert_true(Utils.equals(printer1.get_auth_student().get_id(), student2.get_id()));
    printer1.reset();
    assert_true(Utils.equals(printer1.get_auth_student(), null));
  }

  private void test_queues_linking() {

    Printer printer1 = new Printer(quotes.FEUPQuote.getInstance());
    printer1.auth(student1);
    student1.push_document(document1);
    student1.push_document(document2);
    printer1.sel_student_docs(SeqUtil.seq(1L));
    assert_true(Utils.equals(printer1.get_queue(), SeqUtil.seq(document1)));
    student1.push_document(document3);
    printer1.sel_student_docs(SeqUtil.seq(3L, 1L));
    assert_true(Utils.equals(printer1.get_queue(), SeqUtil.seq(document1, document3, document1)));
    printer1.auth(student2);
    assert_true(Utils.empty(printer1.get_queue()));
    student2.push_document(document1);
    printer1.sel_student_docs(SeqUtil.seq(1L));
    assert_true(Utils.equals(printer1.get_queue(), SeqUtil.seq(document1)));
    printer1.reset();
    assert_true(Utils.empty(printer1.get_queue()));
  }

  private void test_printing() {

    Printer printer2 = new Printer(quotes.FEUPQuote.getInstance());
    printer2.auth(student1);
    printer2.sel_student_docs(SeqUtil.seq(1L));
    Boolean andResult_1 = false;

    if (Utils.equals(printer2.get_queue(), SeqUtil.seq(document1))) {
      if (Utils.equals(student1.get_queue(), SeqUtil.seq(document1, document2, document3))) {
        andResult_1 = true;
      }
    }

    assert_true(andResult_1);

    printer2.auth(student2);
    student2.push_document(document1);
    student2.push_document(document3);
    printer2.sel_student_docs(SeqUtil.seq(1L, 3L));
    assert_true(Utils.equals(printer2.calc_print_cost(), 32L));
    student2.add_balance(10L);
    printer2.print();
    assert_true(Utils.equals(student2.get_balance(), 10L));
    student2.add_balance(30L);
    printer2.print();
    assert_true(
        Utils.equals(printer2.get_statistic(quotes.STAT_DOCS_PRINTEDQuote.getInstance()), 2L));
    assert_true(Utils.equals(student2.get_balance().doubleValue() + 32L, 40L));
  }

  public static void main() {

    PrinterTests pt = new PrinterTests();
    pt.test_printer_id();
    pt.test_student_authentication();
    pt.test_queues_linking();
    pt.test_printing();
  }

  public PrinterTests() {}

  public String toString() {

    return "PrinterTests{"
        + "student1 := "
        + Utils.toString(student1)
        + ", student2 := "
        + Utils.toString(student2)
        + ", document1 := "
        + Utils.toString(document1)
        + ", document2 := "
        + Utils.toString(document2)
        + ", document3 := "
        + Utils.toString(document3)
        + "}";
  }
}
