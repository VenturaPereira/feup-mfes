
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PrintingQueue {
  private VDMSeq documents = SeqUtil.seq();

  public void push_document(final Document document) {

    documents = SeqUtil.conc(Utils.copy(documents), SeqUtil.seq(document));
  }

  public void delete_document(final Document dead_doc) {

    VDMSeq new_queue = SeqUtil.seq();
    Boolean popped = false;
    for (Iterator iterator_4 = documents.iterator(); iterator_4.hasNext(); ) {
      Document this_doc = (Document) iterator_4.next();
      Boolean orResult_3 = false;

      if (!(Utils.equals(dead_doc, this_doc))) {
        orResult_3 = true;
      } else {
        orResult_3 = popped;
      }

      if (orResult_3) {
        new_queue = SeqUtil.conc(Utils.copy(new_queue), SeqUtil.seq(this_doc));
      } else {
        popped = true;
      }
    }
    documents = Utils.copy(new_queue);
  }

  public VDMSeq get_documents() {

    return this.documents;
  }

  public PrintingQueue() {}

  public String toString() {

    return "PrintingQueue{" + "documents := " + Utils.toString(documents) + "}";
  }
}
