
/**
 * Represents bulls and cows for a mastermind game
 */
public final class BullsNCows {
    
    /**
     * Number of bulls
     */
    public final int bulls;

    /**
     * Number of cows
     */
    public final int cows;
    

    /**
     * Constructor of BullsNCows
     * 
     * @param bulls
     *              Number of bulls
     * @param cows 
     *              Number of cows
     */
    public BullsNCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    /**
     * Returns a string which represents this BullsNCows
     * 
     * @return
     *          The string representation of this BullsNCows
     */
    public String toString() {
        return "bulls : " + bulls + ", cows : " + cows;
    }

    /**
     * Determine if a BullsNCows equals another one
     * 
     * Two BullsNCows are equals if their number of 
     * bulls and their number of cows are the same
     */
    public boolean egal(BullsNCows bc) {
        return this.bulls == bc.bulls;
    }
}