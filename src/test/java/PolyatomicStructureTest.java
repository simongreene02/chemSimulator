import org.junit.Before;
import org.junit.Test;

public class PolyatomicStructureTest {
    private PolyatomicStructure ammonium;
    private ElementType nitrogen;
    private ElementType hydrogen;
    @Before
    public void makeAmmonium() {
        nitrogen =
                ElementType.builder()
                        .averageWeight(14.0067)
                        .defaultCharge(-3)
                        .elementName("Nitrogen")
                        .elementNumber(7)
                        .elementSymbol("N")
                        .hasDefaultCharge(true)
                        .metallicStatus(MetallicStatus.NONMETAL)
                        .build();
        hydrogen =
                ElementType.builder()
                        .averageWeight(1.008)
                        .defaultCharge(1)
                        .elementName("Hydrogen")
                        .elementNumber(1)
                        .elementSymbol("H")
                        .hasDefaultCharge(true)
                        .metallicStatus(MetallicStatus.NONMETAL)
                        .build();
        ammonium = new PolyatomicStructure.Builder()
                .elementComposition(new ElementType[] {nitrogen, hydrogen, hydrogen, hydrogen, hydrogen})
                .name("Ammonium")
                .charge(1)
                .build();
    }
    @Test
    public void symbol_positive_scenario() {
        assert ammonium.getSymbol().equals("NH4");
    }
    @Test
    public void weight_positive_scenario() {
        assert ammonium.getTotalMass() == 18.0387;
    }
}
