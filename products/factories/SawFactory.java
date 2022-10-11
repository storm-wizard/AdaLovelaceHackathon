package products.factories;

import products.Item;
import products.impl.Saw;
import products.materials.Steel;

public class SawFactory {

    public static Item createSteelJigsaw() {
        return new Steel(
                new Saw("jigsaw", 50, "wood")).item;
    }
}
