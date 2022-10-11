package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Brass implements sampleInterface {
    public Item item;

    final double BRASS_PREMIUM = 20;
    final String BRASS_DESCRIPTOR = "brass";

    public Brass(Item item) {
        this.item=item;
    }

    public double getPrice() {
        return BRASS_PREMIUM + item.getPrice();
    }

    public double getBrassPremiumPrice() {
        return BRASS_PREMIUM;
    }

    public String toString() {
        return BRASS_DESCRIPTOR + " " + item.toString();
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
