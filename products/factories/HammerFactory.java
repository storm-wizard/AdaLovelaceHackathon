package products.factories;

import products.Item;
import products.impl.Hammer;
import products.materials.Titanium;
import products.materials.Steel;

public class HammerFactory {

    public static Item createHeavySteelSledgeHammer() {
        return new Steel(
                new Hammer("sledge hammer", 40, 14));
    }

    public static Item createLightSteelFramingHammer() {
        return new Steel(
                new Hammer("framing hammer", 30, 3));
    }

}
