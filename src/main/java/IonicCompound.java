/**
 * TODO: Implement getName, getSymbol.
 */

public class IonicCompound implements Compound {
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
            cationCount = lcd / Math.abs(anion.getCharge());
            anionCount = lcd / cation.getCharge();
        } else if (!cation.hasDefaultCharge() && anion.hasDefaultCharge()) {
            cationCount = Math.abs(anion.getCharge());
            anionCount = 1;
        } else if (cation.hasDefaultCharge() && !anion.hasDefaultCharge()) {
            cationCount = 1;
            anionCount = cation.getCharge();
        } else {
            cationCount = 1;
            anionCount = 1;
        }


    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public double getWeight() {
        return cation.getWeight()*cationCount+anion.getWeight()*anionCount;
    }


}
