package visitor;

import products.impl.Hammer;

public class NumberOfHammersCalculator extends ItemVisitor {

    @Override
    public void visit(Hammer hammer) {
        number++;
    }

    public int getNumber() {
        return number;
    }

    private int number = 0;
}
