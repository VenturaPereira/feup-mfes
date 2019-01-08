package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FEUPQuote {
  private static int hc = 0;
  private static FEUPQuote instance = null;

  public FEUPQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FEUPQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FEUPQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FEUPQuote;
  }

  public String toString() {

    return "<FEUP>";
  }
}
