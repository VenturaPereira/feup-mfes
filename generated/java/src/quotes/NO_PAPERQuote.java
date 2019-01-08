package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NO_PAPERQuote {
  private static int hc = 0;
  private static NO_PAPERQuote instance = null;

  public NO_PAPERQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NO_PAPERQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NO_PAPERQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NO_PAPERQuote;
  }

  public String toString() {

    return "<NO_PAPER>";
  }
}
