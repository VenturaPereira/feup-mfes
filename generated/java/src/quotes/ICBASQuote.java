package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ICBASQuote {
  private static int hc = 0;
  private static ICBASQuote instance = null;

  public ICBASQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ICBASQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ICBASQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ICBASQuote;
  }

  public String toString() {

    return "<ICBAS>";
  }
}
