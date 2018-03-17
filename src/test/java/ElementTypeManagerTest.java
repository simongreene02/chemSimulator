import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class ElementTypeManagerTest {

    private static final ElementType ELEMENT_TYPE = ElementType.builder()
            .elementName("Hydrogen")
            .elementNumber(1)
            .elementSymbol("H")
            .averageWeight(1.008)
            .hasDefaultCharge(true)
            .defaultCharge(1)
            .metallicStatus(MetallicStatus.NONMETAL)
            .build();
    private ElementTypeManager elementTypeManager;
    @Before
    public void setUp() {
        elementTypeManager = new ElementTypeManager();
        elementTypeManager.addToElementList(ELEMENT_TYPE);
    }
    @Test
    public void getElementList() {
        assertThat(elementTypeManager.getElementList()).containsExactly(ELEMENT_TYPE);
    }

    @Test
    public void addToElementList() {
        assertThat(elementTypeManager.addToElementList(ELEMENT_TYPE)).isFalse();
        assertThat(elementTypeManager.addToElementList(ElementType.builder(ELEMENT_TYPE).elementName("Helium").build())).isFalse();
        assertThat(elementTypeManager.addToElementList(ElementType.builder(ELEMENT_TYPE)
                .elementName("Helium")
                .elementSymbol("He")
                .elementNumber(2)
                .build())).isTrue();
    }

    @Test
    public void addToElementList_minorValues() {
        assertThat(elementTypeManager.addToElementList(ElementType.builder(ELEMENT_TYPE)
                .averageWeight(2.0)
                .hasDefaultCharge(false)
                .defaultCharge(2)
                .metallicStatus(MetallicStatus.METAL)
                .build())).isFalse();
    }
}