import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PolyatomicStructure {
	private final ElementType[] elementComposition;
	private final String name;
	private final int charge;
	private PolyatomicStructure (Builder builder) {
		this.elementComposition = builder.elementComposition;
		this.name = builder.name;
		this.charge = builder.charge;
	}
	public ElementType[] getElementComposition() {
		return elementComposition;
	}
	public String getName() {
		return name;
	}
	public int getCharge() {
		return charge;
	}
	public double getTotalMass() {
		double totalMass = 0.0;
		for (ElementType element : elementComposition) {
			totalMass += element.getAverageWeight();
		}
		return totalMass;
	}
	public String getSymbol() {
		String output = "";
		for (int i = 0; i < elementComposition.length; i++) {
			output += elementComposition[i].getElementSymbol();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PolyatomicStructure that = (PolyatomicStructure) o;
		return charge == that.charge &&
				Arrays.equals(elementComposition, that.elementComposition) &&
				Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {

		int result = Objects.hash(name, charge);
		result = 31 * result + Arrays.hashCode(elementComposition);
		return result;
	}

	public static class Builder {
		private ElementType[] elementComposition;
		private String name;
		private int charge;
		public Builder prototype(PolyatomicStructure polyatomicStructure) {
			this.elementComposition = polyatomicStructure.elementComposition;
			this.name = polyatomicStructure.name;
			this.charge = polyatomicStructure.charge;
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

		public PolyatomicStructure build() {
			return new PolyatomicStructure(this);
		}
	}
}
