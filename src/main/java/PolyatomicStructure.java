import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Objects;

public class PolyatomicStructure implements IonicCompoundComponent {
    private final ImmutableList<ElementType> elementCompositions;
    private final String name;
    private final int charge;

    private PolyatomicStructure(Builder builder) {
        this.elementCompositions = builder.elementComposition.build();
        this.name = builder.name;
        this.charge = builder.charge;
    }

    public ImmutableList<ElementType> getElementCompositions() {
        return elementCompositions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public boolean hasDefaultCharge() {
        return true;
    }

    @Override
    public double getWeight() {
        double totalMass = 0.0;
        for (ElementType element : elementCompositions) {
            totalMass += element.getWeight();
        }
        return totalMass;
    }

    @Override
    public String getSymbol() {
        return SymbolGetter.getSymbol(elementCompositions);
    }

    public static class Builder {
        private ImmutableList.Builder<ElementType> elementComposition = ImmutableList.builder();
        private String name;
        private int charge;

        public Builder prototype(PolyatomicStructure polyatomicStructure) {
            this.elementComposition.addAll(polyatomicStructure.elementCompositions);
            this.name = polyatomicStructure.name;
            this.charge = polyatomicStructure.charge;
            return this;
        }

        public Builder elementComposition(Collection<ElementType> elementComposition) {
            this.elementComposition.addAll(elementComposition);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder charge(int charge) {
            this.charge = charge;
            return this;
        }

        public PolyatomicStructure build() {
            return new PolyatomicStructure(this);
        }
    }
}
