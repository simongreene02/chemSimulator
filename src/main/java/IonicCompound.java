/**
 * TODO: Add getName, getSymbol, getWeight, create Compound interface, make cation and anion final, make vars for cationCount and anionCount.
 */

public class IonicCompound {
    private IonicCompoundComponent cation;
    private IonicCompoundComponent anion;

    public IonicCompound(IonicCompoundComponent cation, IonicCompoundComponent anion) {
        if (cation.hasDefaultCharge() && cation.getCharge() < 1) {
            throw new IllegalArgumentException("Cations must have either a positive charge or no default charge.");
        }
        if (anion.hasDefaultCharge() && anion.getCharge() > -1) {
            throw new IllegalArgumentException("Anions must have either a negative charge or no default charge.");
        }
        this.cation = cation;
        this.anion = anion;
    }

}
