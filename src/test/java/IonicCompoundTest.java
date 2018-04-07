import com.google.common.collect.ImmutableList;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class IonicCompoundTest {
    private static final ElementType HYDROGEN = ElementType.builder()
            .metallicStatus(MetallicStatus.NONMETAL)
            .defaultCharge(1)
            .hasDefaultCharge(true)
            .averageWeight(1.00794)
            .elementSymbol("H")
            .elementNumber(1)
            .elementName("Hydrogen")
            .build();
    private static final ElementType OXYGEN = ElementType.builder()
            .metallicStatus(MetallicStatus.NONMETAL)
            .defaultCharge(-2)
            .hasDefaultCharge(true)
            .averageWeight(15.999)
            .elementSymbol("O")
            .elementNumber(8)
            .elementName("Oxygen")
            .build();
    private static final ElementType METAL_1 = ElementType.builder()
            .metallicStatus(MetallicStatus.METAL)
            .defaultCharge(2)
            .hasDefaultCharge(false)
            .averageWeight(1)
            .elementSymbol("A")
            .elementNumber(1)
            .elementName("Metal 1")
            .build();
    private static final ElementType METAL_2 = ElementType.builder()
            .metallicStatus(MetallicStatus.METAL)
            .defaultCharge(-3)
            .hasDefaultCharge(false)
            .averageWeight(1)
            .elementSymbol("B")
            .elementNumber(8)
            .elementName("Metal 2")
            .build();

    @Test (expected = IllegalArgumentException.class)
    public void constructor_nonmetalCreation () {
        new IonicCompound(HYDROGEN, OXYGEN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void NegativeCation () {
        new IonicCompound(HYDROGEN, HYDROGEN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void PositiveAnion () {
        new IonicCompound(OXYGEN, OXYGEN);
    }

    @Test
    public void isMetal_metal_true() {
        ElementType hydrogen = ElementType.builder(HYDROGEN)
                .metallicStatus(MetallicStatus.METAL)
                .build();
        assertThat(IonicCompound.isMetal(hydrogen)).isTrue();
    }

    @Test
    public void isMetal_metalloid_true() {
        ElementType hydrogen = ElementType.builder(HYDROGEN)
                .metallicStatus(MetallicStatus.METALLOID)
                .build();
        assertThat(IonicCompound.isMetal(hydrogen)).isTrue();
    }

    @Test
    public void isMetal_polyatomicStructure_true() {
        PolyatomicStructure hydrogenStructure = new PolyatomicStructure.Builder()
                .name("Hydrogen")
                .charge(1)
                .elementComposition(ImmutableList.of(HYDROGEN))
                .build();
        assertThat(IonicCompound.isMetal(hydrogenStructure)).isTrue();
    }

    @Test
    public void constructor_zeroDefaultCharges() {
        IonicCompound compound = new IonicCompound(METAL_1, METAL_2);
        assertThat(compound.getCationCount()).isEqualTo(1);
        assertThat(compound.getAnionCount()).isEqualTo(1);
    }

    @Test
    public void constructor_cationDefaultCharge() {
        ElementType metal1 = ElementType.builder(METAL_1)
                .hasDefaultCharge(true)
                .build();
        IonicCompound compound = new IonicCompound(metal1, METAL_2);
        assertThat(compound.getCationCount()).isEqualTo(1);
        assertThat(compound.getAnionCount()).isEqualTo(2);
    }

    @Test
    public void constructor_anionDefaultCharge() {
        ElementType metal2 = ElementType.builder(METAL_2)
                .hasDefaultCharge(true)
                .build();
        IonicCompound compound = new IonicCompound(METAL_1, metal2);
        assertThat(compound.getCationCount()).isEqualTo(3);
        assertThat(compound.getAnionCount()).isEqualTo(1);
    }

    @Test
    public void constructor_twoDefaultCharges() {
        ElementType metal1 = ElementType.builder(METAL_1)
                .hasDefaultCharge(true)
                .build();
        ElementType metal2 = ElementType.builder(METAL_2)
                .hasDefaultCharge(true)
                .build();
        IonicCompound compound = new IonicCompound(metal1, metal2);
        assertThat(compound.getCationCount()).isEqualTo(3);
        assertThat(compound.getAnionCount()).isEqualTo(2);
    }
}
