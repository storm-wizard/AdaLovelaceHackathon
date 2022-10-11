package products.factories;

import products.Item;
import products.impl.Nails;
import products.materials.Brass;
import products.materials.Steel;

public class NailFactory {

    //   Brass nails for a fancy brass roof
    public static Item createSmallBrassRoofingNails()   {
        return new Brass(
                new Nails("roofing nails", 10.0, 20)).item;
    }

    public static Item createMediumBrassRoofingNails()   {
        return new Brass(
                new Nails("roofing nails", 20.0, 50)).item;
    }


    public static Item createLargeSteelFramingNails() {
        return new Steel(   
                new Nails("framing nails", 45, 200)).item;
    }

}
