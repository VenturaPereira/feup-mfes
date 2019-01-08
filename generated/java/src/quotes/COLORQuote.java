package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class COLORQuote {
  private static int hc = 0;
  private static COLORQuote instance = null;

  public COLORQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static COLORQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new COLORQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof COLORQuote;
  }

  public String toString() {

    return "<COLOR>";
  }
}
