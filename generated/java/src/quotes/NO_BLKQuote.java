package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NO_BLKQuote {
  private static int hc = 0;
  private static NO_BLKQuote instance = null;

  public NO_BLKQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NO_BLKQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NO_BLKQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NO_BLKQuote;
  }

  public String toString() {

    return "<NO_BLK>";
  }
}
