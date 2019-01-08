package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FLUPQuote {
  private static int hc = 0;
  private static FLUPQuote instance = null;

  public FLUPQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FLUPQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FLUPQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FLUPQuote;
  }

  public String toString() {

    return "<FLUP>";
  }
}
