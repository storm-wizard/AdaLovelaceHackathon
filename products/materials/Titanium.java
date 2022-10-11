package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Titanium extends ItemDecorator {

    final double TITANIUM_PREMIUM = 50;
    final String TITANIUM_DESCRIPTOR = "titanium";

    public Titanium(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return TITANIUM_PREMIUM + item.getPrice();
    }

    public double getTitaniumPremiumPrice() {
        return TITANIUM_PREMIUM;
    }
    @Override
    public String toString() {
        return new StringBuilder().append(TITANIUM_DESCRIPTOR).append(" ").append(item.toString()).toString();
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
        item.accept(visitor);
    }
}
