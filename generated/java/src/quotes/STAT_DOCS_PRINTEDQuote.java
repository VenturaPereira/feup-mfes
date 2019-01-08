package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class STAT_DOCS_PRINTEDQuote {
  private static int hc = 0;
  private static STAT_DOCS_PRINTEDQuote instance = null;

  public STAT_DOCS_PRINTEDQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static STAT_DOCS_PRINTEDQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new STAT_DOCS_PRINTEDQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof STAT_DOCS_PRINTEDQuote;
  }

  public String toString() {

    return "<STAT_DOCS_PRINTED>";
  }
}
