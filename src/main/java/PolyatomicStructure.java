import java.util.List;

public class PolyatomicStructure {
	private final ElementType[] elementComposition;
	private final String name;
	private final int charge;
	public PolyatomicStructure(ElementType[] elementComposition, String name, int charge) {
		this.elementComposition = elementComposition;
		this.name = name;
		this.charge = charge;
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
			}
		}
		return output;
	}
	
}
