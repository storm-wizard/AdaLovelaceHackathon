package products;


import visitor.ItemVisitor;

import java.util.ArrayList;

/**
 *  A bundle of items
 */

public class Bundle implements Item {
  
  public Bundle() {
    items = new ArrayList<Item>();
  }

  public Bundle(int size) {
    items = new ArrayList<Item>(size);
  }

  public void add(Item item) {
    items.add(item);
  }

  @Override
  public double getPrice() {
    double price = 0;
    for (Item item : items)
      price += item.getPrice();
    return price;
  }

  @Override
  public String toString() {
    StringBuilder description = new StringBuilder("Bundle: ");
    for (int i = 0; i < items.size(); i++) {
      if (i > 0)
        description.append(", ");
      description.append(items.get(i).toString());
    }
    return description.toString();
  }

  public void accept(ItemVisitor visitor) {
    for (Item item : items) {
      item.accept(visitor);
    }
  }

  private ArrayList<Item> items;
}
