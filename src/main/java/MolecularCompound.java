public class MolecularCompound {
    private final ElementType[] elementComposition;
    private MolecularCompound (Builder builder) {
        this.elementComposition = builder.elementComposition;
    }
    public ElementType[] getElementComposition() {
        return elementComposition;
    }
    public String getSymbol() {
        String output = "";
        for (int i = 0; i < elementComposition.length; i++) {
            output += elementComposition[i].getSymbol();
            int elementCount = 1;
            while (i+elementCount < elementComposition.length && elementComposition[i+elementCount]==elementComposition[i]) {
                elementCount++;
            }
            if (elementCount > 1) {
                output += elementCount;
                i+=elementCount-1;
            }
        }
        return output;
    }
    public static class Builder {
        private ElementType[] elementComposition;
        private String name;
        private int charge;
        public Builder prototype(MolecularCompound molecularCompound) {
            this.elementComposition = molecularCompound.elementComposition;
            return this;
        }

        public Builder elementComposition(ElementType[] elementComposition) {
            this.elementComposition = elementComposition;
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

        public MolecularCompound build() {
            return new MolecularCompound(this);
        }
    }
}
