
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Printer {
  public static final Number BW_PAGE_PRICE = 0.1;
  public static final Number COLOR_PAGE_PRICE = 0.25;
  public static final Number DIM_MULT_PRICE = 2L;
  public static final VDMMap UNI_CODE =
      MapUtil.map(
          new Maplet(quotes.FEUPQuote.getInstance(), "fe"),
          new Maplet(quotes.ICBASQuote.getInstance(), "ic"),
          new Maplet(quotes.FLUPQuote.getInstance(), "fl"));
  public static final VDMMap NAT_2_CHAR =
      MapUtil.map(
          new Maplet(0L, '0'),
          new Maplet(1L, '1'),
          new Maplet(2L, '2'),
          new Maplet(3L, '3'),
          new Maplet(4L, '4'),
          new Maplet(5L, '5'),
          new Maplet(6L, '6'),
          new Maplet(7L, '7'),
          new Maplet(8L, '8'),
          new Maplet(9L, '9'));
  private static VDMMap uni_id =
      MapUtil.map(
          new Maplet(quotes.FEUPQuote.getInstance(), 0L),
          new Maplet(quotes.ICBASQuote.getInstance(), 0L),
          new Maplet(quotes.FLUPQuote.getInstance(), 0L));
  private String id = "Unnamed printer";
  private Student auth_student = null;
  private VDMSeq queue = SeqUtil.seq();
  private VDMMap stats = MapUtil.map();

  public void cg_init_Printer_1(final Object i) {

    id = this.inc_uni_id(((Object) i));
    return;
  }

  public Printer(final Object i) {

    cg_init_Printer_1(i);
  }

  public String inc_uni_id(final Object u) {

    String new_id =
        ((String) Utils.get(UNI_CODE, u))
            + "000"
            + new String(
                new char[] {((Character) Utils.get(NAT_2_CHAR, ((Number) Utils.get(uni_id, u))))});
    uni_id =
        MapUtil.override(
            Utils.copy(Printer.uni_id),
            MapUtil.map(new Maplet(u, ((Number) Utils.get(uni_id, u)).longValue() + 1L)));
    return new_id;
  }

  public void auth(final Student student) {

    auth_student = student;
    queue = SeqUtil.seq();
  }

  public void reset() {

    auth_student = null;
    queue = SeqUtil.seq();
  }

  public void sel_student_docs(final VDMSeq idx) {

    for (Iterator iterator_1 = idx.iterator(); iterator_1.hasNext(); ) {
      Number i = (Number) iterator_1.next();
      Boolean andResult_15 = false;

      if (i.longValue() <= this.auth_student.get_queue().size()) {
        if (i.longValue() > 0L) {
          andResult_15 = true;
        }
      }

      if (andResult_15) {
        queue =
            SeqUtil.conc(
                Utils.copy(queue),
                SeqUtil.seq(((Document) Utils.get(this.auth_student.get_queue(), i))));
      }
    }
  }

  public void print() {

    if (this.check_insufficient_funds()) {
      return;
    }

    auth_student.add_balance(-this.calc_print_cost().doubleValue());
    record_statistic(quotes.STAT_DOCS_PRINTEDQuote.getInstance(), queue.size());
    for (Iterator iterator_2 = this.queue.iterator(); iterator_2.hasNext(); ) {
      Document doc = (Document) iterator_2.next();
      {
        record_statistic(quotes.STAT_PAGES_PRINTEDQuote.getInstance(), doc.get_page_no());
        auth_student.delete_document(doc);
        queue = SeqUtil.tail(Utils.copy(queue));
      }
    }
  }

  public Number calc_print_cost() {

    Number op_cost = 0.0;
    for (Iterator iterator_3 = this.queue.iterator(); iterator_3.hasNext(); ) {
      Document doc = (Document) iterator_3.next();
      {
        Number subtotal = 0.0;
        if (Utils.equals(doc.get_color(), quotes.BWQuote.getInstance())) {
          subtotal =
              subtotal.doubleValue()
                  + Printer.BW_PAGE_PRICE.doubleValue() * doc.get_page_no().longValue();
        } else {
          subtotal =
              subtotal.doubleValue()
                  + Printer.COLOR_PAGE_PRICE.doubleValue() * doc.get_page_no().longValue();
        }

        if (Utils.equals(doc.get_dimension(), quotes.A3Quote.getInstance())) {
          subtotal = subtotal.doubleValue() * Printer.DIM_MULT_PRICE.doubleValue();
        }

        op_cost = op_cost.doubleValue() + subtotal.doubleValue();
      }
    }
    return Utils.divide((1.0 * Math.round(Utils.floor(op_cost.doubleValue() * 100L))), 100L);
  }

  public Boolean check_insufficient_funds() {

    return calc_print_cost().doubleValue() > this.auth_student.get_balance().doubleValue();
  }

  public void record_statistic(final Object s, final Number v) {

    if (!(SetUtil.inSet(s, MapUtil.dom(Utils.copy(stats))))) {
      stats = MapUtil.override(Utils.copy(stats), MapUtil.map(new Maplet(s, v)));
    } else {
      stats =
          MapUtil.override(
              Utils.copy(stats),
              MapUtil.map(
                  new Maplet(s, ((Number) Utils.get(stats, s)).longValue() + v.longValue())));
    }
  }

  public String get_id() {

    return this.id;
  }

  public Student get_auth_student() {

    return this.auth_student;
  }

  public VDMSeq get_queue() {

    return this.queue;
  }

  public Number get_statistic(final Object s) {

    return ((Number) Utils.get(this.stats, s));
  }

  public Printer() {}

  public static Boolean assert_id_syntax(final String id_1) {

    Boolean andResult_17 = false;

    Boolean orResult_1 = false;

    if (has_substring("fe", id_1)) {
      orResult_1 = true;
    } else {
      Boolean orResult_2 = false;

      if (has_substring("fl", id_1)) {
        orResult_2 = true;
      } else {
        orResult_2 = has_substring("ic", id_1);
      }

      orResult_1 = orResult_2;
    }

    if (orResult_1) {
      if (Utils.equals(id_1.length(), 6L)) {
        andResult_17 = true;
      }
    }

    return andResult_17;
  }

  public static Boolean has_substring(final String s1, final String s2) {

    return Utils.equals(SetUtil.intersect(SeqUtil.elems(s1), SeqUtil.elems(s2)), SeqUtil.elems(s1));
  }

  public static Boolean assert_statistics(
      final Object s, final Number v, final VDMMap new_s, final VDMMap old_s) {

    if (!(SetUtil.inSet(s, MapUtil.dom(Utils.copy(old_s))))) {
      return Utils.equals(((Number) Utils.get(new_s, s)), v);

    } else {
      return Utils.equals(
          new_s,
          MapUtil.override(
              Utils.copy(old_s),
              MapUtil.map(
                  new Maplet(s, ((Number) Utils.get(old_s, s)).longValue() + v.longValue()))));
    }
  }

  public String toString() {

    return "Printer{"
        + "BW_PAGE_PRICE = "
        + Utils.toString(BW_PAGE_PRICE)
        + ", COLOR_PAGE_PRICE = "
        + Utils.toString(COLOR_PAGE_PRICE)
        + ", DIM_MULT_PRICE = "
        + Utils.toString(DIM_MULT_PRICE)
        + ", UNI_CODE = "
        + Utils.toString(UNI_CODE)
        + ", NAT_2_CHAR = "
        + Utils.toString(NAT_2_CHAR)
        + ", uni_id := "
        + Utils.toString(uni_id)
        + ", id := "
        + Utils.toString(id)
        + ", auth_student := "
        + Utils.toString(auth_student)
        + ", queue := "
        + Utils.toString(queue)
        + ", stats := "
        + Utils.toString(stats)
        + "}";
  }
}
