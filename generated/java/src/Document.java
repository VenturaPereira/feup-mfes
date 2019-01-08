
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Document {
  private String title = "Untitled document";
  private Number page_no = 1L;
  private Object color = quotes.COLORQuote.getInstance();
  private Object dimension = quotes.A4Quote.getInstance();

  public void cg_init_Document_1(final String t, final Number pn, final Object c, final Object d) {

    title = t;
    page_no = pn;
    color = c;
    dimension = d;
    return;
  }

  public Document(final String t, final Number pn, final Object c, final Object d) {

    cg_init_Document_1(t, pn, c, d);
  }

  public String get_title() {

    return this.title;
  }

  public Number get_page_no() {

    return this.page_no;
  }

  public Object get_color() {

    return this.color;
  }

  public Object get_dimension() {

    return this.dimension;
  }

  public Document() {}

  public String toString() {

    return "Document{"
        + "title := "
        + Utils.toString(title)
        + ", page_no := "
        + Utils.toString(page_no)
        + ", color := "
        + Utils.toString(color)
        + ", dimension := "
        + Utils.toString(dimension)
        + "}";
  }
}
