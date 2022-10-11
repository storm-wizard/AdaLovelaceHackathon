package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Steel {
    public Item item;
    final double STEEL_PREMIUM = 10;
    final String STEEL_DESCRIPTOR = "steel";

    public Steel(Item item) {
        this.item=item;
    }

   
    public double getPrice() {
        return STEEL_PREMIUM + item.getPrice();
    }

    public double getSteelPremiumPrice() {
        return STEEL_PREMIUM;
    }

    
    public String toString() {
        return STEEL_DESCRIPTOR + " " +  item.toString();
    }

   
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
