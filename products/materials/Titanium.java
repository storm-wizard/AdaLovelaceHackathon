package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Titanium {
    Item item;

    final double TITANIUM_PREMIUM = 50;
    final String TITANIUM_DESCRIPTOR = "titanium";

    public Titanium(Item item) {
        this.item = item;
    }

    public double getPrice() {
        return TITANIUM_PREMIUM + item.getPrice();
    }

    public double getTitaniumPremiumPrice() {
        return TITANIUM_PREMIUM;
    }

    public String toString() {
        return new StringBuilder().append(TITANIUM_DESCRIPTOR).append(" ").append(item.toString()).toString();
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
