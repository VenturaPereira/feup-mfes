package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UNKNOWNQuote {
  private static int hc = 0;
  private static UNKNOWNQuote instance = null;

  public UNKNOWNQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static UNKNOWNQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new UNKNOWNQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof UNKNOWNQuote;
  }

  public String toString() {

    return "<UNKNOWN>";
  }
}
