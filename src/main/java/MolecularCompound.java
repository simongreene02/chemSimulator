import com.google.common.collect.ImmutableList;

import java.util.Collection;

public class MolecularCompound implements Compound {
    private final ImmutableList<ElementType> elementComposition;
    public MolecularCompound(Collection<ElementType> elementCollection) {
        for (ElementType element : elementCollection) {
            if (element.getMetallicStatus() != MetallicStatus.NONMETAL) {
                throw new IllegalArgumentException("Molecular Compounds must contain only non-metals.");
            }
        }
        elementComposition = ImmutableList.copyOf(elementCollection);
    }
    public ImmutableList<ElementType> getElementComposition() {
        return elementComposition;
    }

    @Override
    public String getName() {
        return null;
    }

    public String getSymbol() {
        return SymbolGetter.getSymbol(elementComposition);
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
