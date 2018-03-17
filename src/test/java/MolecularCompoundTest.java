import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class MolecularCompoundTest {
    @Test
    public void init_empty() {
        MolecularCompound compound = new MolecularCompound(ImmutableList.of());
        assertThat(compound.getElementComposition()).isEmpty();
    }
    @Test
    public void init_oneItem() {
        ElementType element = builder().build();
        MolecularCompound compound = new MolecularCompound(ImmutableList.of(element));
        assertThat(Iterables.getOnlyElement(compound.getElementComposition())).isSameAs(element);
    }
    @Test (expected = IllegalArgumentException.class)
    public void init_badItem() {
        ElementType element = builder()
                .metallicStatus(MetallicStatus.METAL)
                .build();
        new MolecularCompound(ImmutableList.of(element));
    }
    private static ElementType.Builder builder() {
        return ElementType.builder()
                .elementName("Hydrogen")
                .elementNumber(1)
                .elementSymbol("H")
                .averageWeight(1.008)
                .hasDefaultCharge(true)
                .defaultCharge(1)
                .metallicStatus(MetallicStatus.NONMETAL);
    }
}