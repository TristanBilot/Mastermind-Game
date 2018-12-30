
/**
 * A code is a set of slot 
 */
public final class Code {

    /**
     * Numbers of slot
     */
    public static final int CODE_SIZE = 2;
    
    /**
     * The number of value that can take a slot
     */
    public static final int CODE_RANGE = 13;

    /**
     * The slots
     */
    public final int[] nc;


    /**
     * Constructor of Code
     * 
     * @param nc
     *          The values of the slots
     * @throws IllegalArgumentException if the length of nc is 0 
     *                  or if the value of a slot is out of range
     */
    public Code(int[] nc) {
        if (nc.length != CODE_SIZE)
            throw new IllegalArgumentException("The code needs to have a size of " + CODE_SIZE);
        for (int i = 0; i < CODE_SIZE; ++i) 
            if (nc[i] < 0 || nc[i] >= CODE_RANGE)
                throw new IllegalArgumentException("Each number should be between 0 and " + (CODE_RANGE - 1));
        
        this.nc = new int[CODE_SIZE];
        for (int i = 0; i < CODE_SIZE; i++)
            this.nc[i] = nc[i]; 
    } 

    /**
     * Returns a string which represents this Code
     * 
     * @return
     *          The string representation of this Code
     */
    public String toString() {
        String ret = "|";
        for (int n : nc)
            ret += n + "|";
        return ret;
    }
}