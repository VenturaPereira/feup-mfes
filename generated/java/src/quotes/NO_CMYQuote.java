package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NO_CMYQuote {
  private static int hc = 0;
  private static NO_CMYQuote instance = null;

  public NO_CMYQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NO_CMYQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NO_CMYQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NO_CMYQuote;
  }

  public String toString() {

    return "<NO_CMY>";
  }
}
