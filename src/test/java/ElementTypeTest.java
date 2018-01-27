import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class ElementTypeTest {

	@Test
	public void equalities() {
		ElementType hydrogen = ElementType.builder()
				.elementName("Hydrogen")
				.elementNumber(1)
				.elementSymbol("H")
				.averageWeight(1.008)
				.hasDefaultCharge(true)
				.defaultCharge(1)
				.metallicStatus(MetallicStatus.NONMETAL)
				.build();

		new EqualsTester()
				.addEqualityGroup(hydrogen, ElementType.builder(hydrogen).build())
				.addEqualityGroup(ElementType.builder(hydrogen).elementName("Helium").build())
				.addEqualityGroup(ElementType.builder(hydrogen).elementNumber(2).build())
				.addEqualityGroup(ElementType.builder(hydrogen).elementSymbol("He").build())
				.addEqualityGroup(ElementType.builder(hydrogen).averageWeight(2.0).build())
				.addEqualityGroup(ElementType.builder(hydrogen).hasDefaultCharge(false).build())
				.addEqualityGroup(ElementType.builder(hydrogen).defaultCharge(-1).build())
				.addEqualityGroup(ElementType.builder(hydrogen).metallicStatus(MetallicStatus.METAL).build())
				.testEquals();
	}

}
