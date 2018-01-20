import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ElementType {

//	private static List<ElementType> elementList = new ArrayList<ElementType>();
	private static Set<ElementType> elementSet = new HashSet<>();
	private final String elementName;
	private final int elementNumber;
	private final String elementSymbol;
	private final double averageWeight;
	private final boolean hasDefaultCharge;
	private final int defaultCharge;
	private final MetalicStatus metalicStatus;
	public ElementType(String elementName, int elementNumber, String elementSymbol, double averageWeight,
			boolean hasDefaultCharge, int defaultCharge, MetalicStatus metalicStatus) {
		this.elementName = elementName;
		this.elementNumber = elementNumber;
		this.elementSymbol = elementSymbol;
		this.averageWeight = averageWeight;
		this.hasDefaultCharge = hasDefaultCharge;
		this.defaultCharge = defaultCharge;
		this.metalicStatus = metalicStatus;
		
		elementSet.add(this);
	}
//	public static List<ElementType> getElementList() {
//		return elementList;
//	}
	
	public String getElementName() {
		return elementName;
	}
	public static Set<ElementType> getElementSet() {
		return elementSet;
	}

	public int getElementNumber() {
		return elementNumber;
	}
	public String getElementSymbol() {
		return elementSymbol;
	}
	public double getAverageWeight() {
		return averageWeight;
	}
	public boolean isHasDefaultCharge() {
		return hasDefaultCharge;
	}
	public int getDefaultCharge() {
		return defaultCharge;
	}
	public MetalicStatus getMetalicStatus() {
		return metalicStatus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(elementNumber, elementSymbol);
	}
	@Override
	public boolean equals(Object other) {
		if ( other == this) {
			return true;
		}
		if (other instanceof ElementType) {
			ElementType that = (ElementType)other;
			return this.elementNumber == that.elementNumber && this.elementSymbol.equals(that.elementSymbol);
		}
		return false; 
	}
	
}
