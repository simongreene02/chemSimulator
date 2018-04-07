import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Implement getName.
 */

public class IonicCompound implements Compound {
    private static final Logger log = LoggerFactory.getLogger(IonicCompound.class);
    /**
     * Cation charge >= 1
     * Cation charge <= {@link Integer#MAX_VALUE}
     */
    private final IonicCompoundComponent cation;
    /**
     * Anion charge <= -1
     * Anion charge >= {@link Integer#MIN_VALUE}
     */
    private final IonicCompoundComponent anion;
    /**
     * Cation count >= 1
     * Cation count <= {@link Integer#MAX_VALUE}
     */
    private final int cationCount;
    /**
     * Anion count >= 1
     * Anion count <= {@link Integer#MAX_VALUE}
     */
    private final int anionCount;

    public IonicCompound(IonicCompoundComponent cation, IonicCompoundComponent anion) {
        if (!isMetal(cation) && !isMetal(anion)) {
            throw new IllegalArgumentException("Either the cation or the anion must be a metal, metalloid, or a polyatomic structure.");
        }
        if (cation.hasDefaultCharge() && cation.getCharge() < 1) {
            throw new IllegalArgumentException("Cations must have either a positive charge or no default charge.");
        }
        if (anion.hasDefaultCharge() && anion.getCharge() > -1) {
            throw new IllegalArgumentException("Anions must have either a negative charge or no default charge.");
        }
        this.cation = cation;
        this.anion = anion;
        if (cation.hasDefaultCharge() && anion.hasDefaultCharge()) {
            int lcd = LeastCommonDenominatorFinder.leastCommonDenominator(cation.getCharge(), anion.getCharge());
            log.info("lcd: {}", lcd);
            cationCount = lcd / cation.getCharge();
            anionCount = lcd / Math.abs(anion.getCharge());
        } else if (!cation.hasDefaultCharge() && anion.hasDefaultCharge()) {
            //Anion default charge
            cationCount = Math.abs(anion.getCharge());
            anionCount = 1;
        } else if (cation.hasDefaultCharge() && !anion.hasDefaultCharge()) {
            //Cation default charge
            cationCount = 1;
            anionCount = cation.getCharge();
        } else {
            //Zero default charges
            cationCount = 1;
            anionCount = 1;
        }


    }

    @VisibleForTesting static boolean isMetal(IonicCompoundComponent component) {
        return component instanceof PolyatomicStructure || ((ElementType) component).getMetallicStatus() != MetallicStatus.NONMETAL;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSymbol() {
        return cation.getSymbol()+(cationCount>1?cationCount:"")+anion.getSymbol()+(anionCount>1?anionCount:"");
    }

    @Override
    public double getWeight() {
        return cation.getWeight()*cationCount+anion.getWeight()*anionCount;
    }

    @VisibleForTesting int getCationCount() {
        return cationCount;
    }

    @VisibleForTesting int getAnionCount() {
        return anionCount;
    }
}
