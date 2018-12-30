import java.util.*;

/**
 * An example of how to use the Mastermind class
 */
public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nbCoups;
        Code[] cd;
        BullsNCows[] bc;

        System.out.print("Veuillez entrer le nombre de coups : ");
        
        nbCoups = sc.nextInt();
        
        cd = new Code[nbCoups];
        bc = new BullsNCows[nbCoups];
        for (int i = 0; i < nbCoups; i++) {
            System.out.print("Code n°" + (i+1) + " : ");
            int[] nb = new int[Code.CODE_SIZE];
            for (int j = 0; j < Code.CODE_SIZE; j++) nb[j] = sc.nextInt();
            cd[i] = new Code(nb);
            System.out.print("Bulls : ");
            int bulls = sc.nextInt();
            System.out.print("Cows : ");
            int cows = sc.nextInt();
            bc[i] = new BullsNCows(bulls, cows);
        }
        
        System.out.println(Mastermind.findSolutions(cd, bc));
    }
}