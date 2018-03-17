import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import org.junit.Test;

public class SymbolGetterTest {
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

    @Test
    public void symbol_singleElement_positive() {
        Truth.assertThat(SymbolGetter.getSymbol(ImmutableList.of(NITROGEN))).isEqualTo("N");
    }

    @Test
    public void symbol_positive_scenario() {
        Truth.assertThat(SymbolGetter.getSymbol(ImmutableList.of(NITROGEN, HYDROGEN, HYDROGEN, HYDROGEN, HYDROGEN)))
                .isEqualTo("NH4");
    }
    @Test
    public void symbol_noElement_positive() {
        Truth.assertThat(SymbolGetter.getSymbol(ImmutableList.of())).isEqualTo("");
    }
}