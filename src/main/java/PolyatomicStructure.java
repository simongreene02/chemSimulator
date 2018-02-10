import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class PolyatomicStructure implements CompoundComponent {
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
    public double getWeight() {
        double totalMass = 0.0;
        for (ElementType element : elementCompositions) {
            totalMass += element.getWeight();
        }
        return totalMass;
    }

    @Override
    public String getSymbol() {
        Map<ElementType, Integer> elementTypeIntegerMap = Maps.newLinkedHashMap();
        for (ElementType element : elementCompositions) {
            if (elementTypeIntegerMap.containsKey(element)) {
                elementTypeIntegerMap.put(element, elementTypeIntegerMap.get(element)+1);
            } else {
                elementTypeIntegerMap.put(element, 1);
            }
        }
        StringBuilder output = new StringBuilder();
        for (Map.Entry<ElementType, Integer> entry : elementTypeIntegerMap.entrySet()) {
            output.append(entry.getKey());
            if (entry.getValue() > 1) {
                output.append(entry.getValue());
            }
        }
        return output.toString();
    }

    public String alt_universe_getSymbol() {
        String output = "";
        for (int i = 0; i < elementCompositions.size(); i++) {
            output += elementCompositions.get(i).getSymbol();
            int elementCount = 1;
            while (i + elementCount < elementCompositions.size()
                    && elementCompositions.get(i + elementCount) == elementCompositions.get(i)) {
                elementCount++;
            }
            if (elementCount > 1) {
                output += elementCount;
                i += elementCount - 1;
            }
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyatomicStructure that = (PolyatomicStructure) o;
        return charge == that.charge &&
                Objects.equals(elementCompositions, that.elementCompositions) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementCompositions, name, charge);
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
