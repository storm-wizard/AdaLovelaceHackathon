package invoice;

import products.Item;
import visitor.ItemVisitor;
import visitor.PriceCalculator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An invoice for a sale, consisting of items.
 */

public class Invoice {

  public Invoice() {
    items = new ArrayList<Item>();
  }

  public Invoice(int size) {
    items = new ArrayList<Item>(size);
  }
  
  public Invoice(ArrayList<Item> initialItems) {
    items = initialItems;
  }
  
  public void addItem(Item item) {
    items.add(item);
  }


  // Return an iterator for the items.
  public Iterator<Item> getItems() {
    return new Iterator<Item>() {
      public boolean hasNext() {
        return current < items.size();
      }

      public Item next() {
        return items.get(current++);
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }

      private int current = 0;
    };
  }

  public String format(InvoiceFormatter formatter) {
    String formattedInvoice = formatter.formatHeader();
    StringBuilder formattedInvoiceBuilder = new StringBuilder(formattedInvoice);
    Iterator<Item> iter = getItems();
    PriceCalculator calculator = new PriceCalculator();
    while (iter.hasNext()) {
      Item item = iter.next();
      formattedInvoiceBuilder.append(formatter.formatItem(item));
      accept(calculator);
      formatter.setTotalPrice(calculator.getTotalPrice());
    }
    formattedInvoiceBuilder.append(formatter.formatFooter());
    return formattedInvoiceBuilder.toString();
  }

  public void accept(ItemVisitor visitor) {
    Iterator<Item> iter = getItems();
    while (iter.hasNext())
      iter.next().accept(visitor);
  }

  private ArrayList<Item> items;
}
