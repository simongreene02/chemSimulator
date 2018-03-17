import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import org.junit.Test;

public class PolyatomicStructureTest {
    private static final ElementType NITROGEN =
            ElementType.builder()
            .averageWeight(14.0067)
                        .defaultCharge(-3)
                        .elementName("Nitrogen")
                        .elementNumber(7)
                        .elementSymbol("N")
                        .hasDefaultCharge(true)
                        .metallicStatus(MetallicStatus.NONMETAL)
                        .build();
    private static final ElementType HYDROGEN =
            ElementType.builder()
            .averageWeight(1.008)
                        .defaultCharge(1)
                        .elementName("Hydrogen")
                        .elementNumber(1)
                        .elementSymbol("H")
                        .hasDefaultCharge(true)
                        .metallicStatus(MetallicStatus.NONMETAL)
                        .build();
    private static final PolyatomicStructure AMMONIUM = new PolyatomicStructure.Builder()
            .elementComposition(ImmutableList.of(NITROGEN, HYDROGEN, HYDROGEN, HYDROGEN, HYDROGEN))
            .name("Ammonium")
                .charge(1)
                .build();
    @Test
    public void weight_positive_scenario() {
        Truth.assertThat(AMMONIUM.getWeight()).isWithin(0.00001).of(18.0387);
    }
    @Test
    public void weight_empty_scenario() {
        Truth.assertThat(new PolyatomicStructure.Builder().build().getWeight()).isWithin(0.00001).of(0);
    }
}
