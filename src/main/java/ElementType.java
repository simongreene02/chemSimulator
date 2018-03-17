import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElementType implements IonicCompoundComponent {

	private final String elementName;
	private final int elementNumber;
	private final String elementSymbol;
	private final double averageWeight;
	private final boolean hasDefaultCharge;
	private final int defaultCharge;
	private final MetallicStatus metallicStatus;

	private ElementType(Builder builder) {
		this.elementName = builder.elementName;
		this.elementNumber = builder.elementNumber;
		this.elementSymbol = builder.elementSymbol;
		this.averageWeight = builder.averageWeight;
		this.hasDefaultCharge = builder.hasDefaultCharge;
		this.defaultCharge = builder.defaultCharge;
		this.metallicStatus = builder.metallicStatus;
	}

	@Override
	public String getName() {
		return elementName;
	}
	//public static Set<ElementType> getElementSet() {
	//	return elementSet;
	//}

	public int getElementNumber() {
		return elementNumber;
	}
	@Override
	public String getSymbol() {
		return elementSymbol;
	}
	@Override
	public double getWeight() {
		return averageWeight;
	}
	@Override
	public boolean hasDefaultCharge() {
		return hasDefaultCharge;
	}
	@Override
	public int getCharge() {
		return defaultCharge;
	}
	public MetallicStatus getMetallicStatus() {
		return metallicStatus;
	}

	public static Builder builder() {
		return new Builder();
	}
	public static Builder builder(ElementType element) {
		return new Builder().prototype(element);
	}
	public static class Builder {
		private String elementName;
		private int elementNumber;
		private String elementSymbol;
		private double averageWeight;
		private boolean hasDefaultCharge;
		private int defaultCharge;
		private MetallicStatus metallicStatus;
		public Builder prototype(ElementType element) {
			this.elementName = element.elementName;
			this.elementNumber = element.elementNumber;
			this.elementSymbol = element.elementSymbol;
			this.averageWeight = element.averageWeight;
			this.hasDefaultCharge = element.hasDefaultCharge;
			this.defaultCharge = element.defaultCharge;
			this.metallicStatus = element.metallicStatus;
			return this;
		}

		public Builder elementName(String elementName) {
			this.elementName = elementName;
			return this;
		}

		public Builder elementNumber(int elementNumber) {
			this.elementNumber = elementNumber;
			return this;
		}

		public Builder elementSymbol(String elementSymbol) {
			this.elementSymbol = elementSymbol;
			return this;
		}

		public Builder averageWeight(double averageWeight) {
			this.averageWeight = averageWeight;
			return this;
		}

		public Builder hasDefaultCharge(boolean hasDefaultCharge) {
			this.hasDefaultCharge = hasDefaultCharge;
			return this;
		}

		public Builder defaultCharge(int defaultCharge) {
			this.defaultCharge = defaultCharge;
			return this;
		}

		public Builder metallicStatus(MetallicStatus metallicStatus) {
			this.metallicStatus = metallicStatus;
			return this;
		}
		public ElementType build() {
			return new ElementType(this);
		}
	}
	
}
