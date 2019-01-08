
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class StudentTests extends TestSuite {
  private Student student1 = new Student("fe201503538");
  private Student student2 = new Student("fl201407644");
  private Student student3 = new Student("ic201793252");
  private Document document1 =
      new Document("d1", 20L, quotes.BWQuote.getInstance(), quotes.A4Quote.getInstance());
  private Document document2 =
      new Document("d2", 40L, quotes.COLORQuote.getInstance(), quotes.A3Quote.getInstance());
  private Document document3 =
      new Document("d3", 60L, quotes.COLORQuote.getInstance(), quotes.A4Quote.getInstance());

  private void test_balance_mod() {

    student1.add_balance(4.25);
    assert_true(Utils.equals(student1.get_balance(), 4.25));
    student1.add_balance(-3.25);
    assert_true(Utils.equals(student1.get_balance(), 1.0));
  }

  private void test_printing_queue() {

    student1.push_document(document1);
    assert_true(Utils.equals(student1.get_queue(), SeqUtil.seq(document1)));
    student1.push_document(document1);
    student1.push_document(document2);
    assert_true(Utils.equals(student1.get_queue(), SeqUtil.seq(document1, document1, document2)));
    student1.delete_document(document1);
    assert_true(Utils.equals(student1.get_queue(), SeqUtil.seq(document1, document2)));
    student1.delete_document(document2);
    student1.push_document(document1);
    assert_true(Utils.equals(student1.get_queue(), SeqUtil.seq(document1, document1)));
  }

  private void test_id_retrieval() {

    assert_true(Utils.equals(student1.get_id(), "fe201503538"));
    assert_true(Utils.equals(student3.get_id(), "ic201793252"));
  }

  public static void main() {

    StudentTests stt = new StudentTests();
    stt.test_balance_mod();
    stt.test_printing_queue();
    stt.test_id_retrieval();
  }

  public StudentTests() {}

  public String toString() {

    return "StudentTests{"
        + "student1 := "
        + Utils.toString(student1)
        + ", student2 := "
        + Utils.toString(student2)
        + ", student3 := "
        + Utils.toString(student3)
        + ", document1 := "
        + Utils.toString(document1)
        + ", document2 := "
        + Utils.toString(document2)
        + ", document3 := "
        + Utils.toString(document3)
        + "}";
  }
}
