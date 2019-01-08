package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BWQuote {
  private static int hc = 0;
  private static BWQuote instance = null;

  public BWQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BWQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BWQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BWQuote;
  }

  public String toString() {

    return "<BW>";
  }
}
