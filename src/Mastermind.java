import java.util.ArrayList;

/**
 * Represents a mastermind board
 */
public class Mastermind {

    /**
     * The secret code of this mastermind's game
     */
    private final Code code;
    
    /**
     * Constructor of a mastermind object
     * 
     * @param code
     *          The secret code for this mastermind game
     */
    public Mastermind(Code code) {
        this.code = code;
    }

    /**
     * Returns the bulls and cows of a guess
     * 
     * @param code
     *          The guess
     * @return
     *          Bulls and cows of this guess
     */
    public BullsNCows guess(Code code) {
        int bulls = 0, cows = 0;
        boolean[] checked = new boolean[Code.CODE_SIZE];
        boolean[] checkedO = new boolean[Code.CODE_SIZE];
        for (int i = 0; i < Code.CODE_SIZE; i++) {
            checked[i] = false;
            checkedO[i] = false;
        }

        for (int i = 0; i < Code.CODE_SIZE; i++)
             if (this.code.nc[i] == code.nc[i]) { bulls++; checked[i]=true; checkedO[i]=true; }
        
        for (int i = 0; i < Code.CODE_SIZE; i++)
            if (!checked[i])
                for (int j = 0; j < Code.CODE_SIZE; j++)
                    if (i != j && !checkedO[j] && this.code.nc[i] == code.nc[j]) {
                        cows++;
                        checkedO[j] = true;
                        break;
                    }

        return new BullsNCows(bulls, cows);
    }


    /**
     * Returns all solutions code for a set of Code and BullsNCows
     * 
     * @param cd
     *          The set of Code
     * @param bc 
     *          The set of bc
     * @return 
     *          The solutions
     * @throws IllegalArgumentException if cd and bc doesn't have the same length
     *                      or if their is no Code nor BullsNCows
     */
    public static ArrayList<Code> findSolutions(Code[] cd, BullsNCows[] bc) {
        if (cd.length != bc.length)
            throw new IllegalArgumentException("There should be the same number of Codes and BullsNCows");
        if (cd.length == 0)
            throw new IllegalArgumentException("There is no codes nor BullsNCows");
        
        int[] nc = new int[Code.CODE_SIZE];
        for (int i = 0; i < Code.CODE_SIZE; i++) nc[i] = 0;
        ArrayList<Code> solutions = new ArrayList<Code>();
        int max = (int) Math.pow(Code.CODE_RANGE, Code.CODE_SIZE);

        for (int i = 0; i < max; i++) {
           
            Code current = new Code(nc);
            Mastermind mm = new Mastermind(current);
            boolean ok = true;
            for (int j = 0; j < bc.length; j++) {
                if (!mm.guess(cd[j]).egal(bc[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                solutions.add(current);
            }

            nc[Code.CODE_SIZE-1]++;
            for (int j = Code.CODE_SIZE-1; j > 0; j--)
                if (nc[j] == Code.CODE_RANGE) {
                    nc[j] = 0;
                    nc[j - 1]++;
                }
        }

        return solutions;
    }

    /**
     * Returns a string which represents this Mastermind board
     * 
     * @return
     *          The string representation of this Mastermind board
     */
    public String toString() {
        return code.toString();
    }
}