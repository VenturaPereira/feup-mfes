package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class STAT_PAGES_PRINTEDQuote {
  private static int hc = 0;
  private static STAT_PAGES_PRINTEDQuote instance = null;

  public STAT_PAGES_PRINTEDQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static STAT_PAGES_PRINTEDQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new STAT_PAGES_PRINTEDQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof STAT_PAGES_PRINTEDQuote;
  }

  public String toString() {

    return "<STAT_PAGES_PRINTED>";
  }
}
