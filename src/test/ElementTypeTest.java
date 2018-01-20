import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ElementTypeTest {

	@Test
	public void constructor_same() {
		ElementType hydrogen = new ElementType("Hydrogen", 1, "H", 1.008, true, 1, MetalicStatus.NONMETAL);
		ElementType hydrogen2 = new ElementType("Hydrogen2", 1, "H", 5.008, false, 1, MetalicStatus.METAL);
		Set<ElementType> abc = ElementType.getElementSet();
		Assert.assertEquals(1, abc.size());
		assertSame(hydrogen, abc.iterator().next());
	}
	@Test
	public void constructor_diffNumber() {
		ElementType hydrogen = new ElementType("Hydrogen", 1, "H", 1.008, true, 1, MetalicStatus.NONMETAL);
		ElementType hydrogen2 = new ElementType("Hydrogen", 2, "H", 1.008, true, 1, MetalicStatus.NONMETAL);
		Set<ElementType> abc = ElementType.getElementSet();
		Assert.assertEquals(1, abc.size());
		assertSame(hydrogen, abc.iterator().next());
	}
	@Test
	public void constructor_diffSymb() {
		ElementType hydrogen = new ElementType("Hydrogen", 1, "H", 1.008, true, 1, MetalicStatus.NONMETAL);
		ElementType hydrogen2 = new ElementType("Hydrogen", 1, "He", 1.008, true, 1, MetalicStatus.NONMETAL);
		Set<ElementType> abc = ElementType.getElementSet();
		Assert.assertEquals(1, abc.size());
		assertSame(hydrogen, abc.iterator().next());
	}
}
