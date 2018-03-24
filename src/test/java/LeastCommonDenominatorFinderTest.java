import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class LeastCommonDenominatorFinderTest {

    @Test
    public void leastCommonDenominator_twoZeroes() {
        assertThat(LeastCommonDenominatorFinder.leastCommonDenominator(0, 0)).isEqualTo(0);
    }
    @Test
    public void leastCommonDenominator_oneZero() {
        assertThat(LeastCommonDenominatorFinder.leastCommonDenominator(0, 1)).isEqualTo(0);
    }
    @Test
    public void leastCommonDenominator_negativeB() {
        assertThat(LeastCommonDenominatorFinder.leastCommonDenominator(2, -3)).isEqualTo(6);
    }
    @Test
    public void leastCommonDenominator_twoPositives() {
        assertThat(LeastCommonDenominatorFinder.leastCommonDenominator(4, 6)).isEqualTo(12);
    }
    @Test
    public void leastCommonDenominator_threeAndNine() {
        assertThat(LeastCommonDenominatorFinder.leastCommonDenominator(3, 9)).isEqualTo(9);
    }
}