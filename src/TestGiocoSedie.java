package giocosedie;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author ThomasMonacchia
 */
public class TestGiocoSedie {
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Posto sedie[] = new Posto[NUMSEDIE];

        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        // Creazione del Display per mostrare l'andamento del gioco
        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();
        
        // Scanner per acquisire l'input dell'utente
        Scanner scanner = new Scanner(System.in);
        
        // Inserire il numero di partecipanti
        int numPartecipanti;
        do {
            System.out.print("Inserisci il numero di partecipanti (max " + NUMSEDIE + "): ");
            numPartecipanti = scanner.nextInt();

            if (numPartecipanti > NUMSEDIE) {
                System.out.println("Il numero di partecipanti non può essere maggiore del numero di sedie.");
            }
        } while (numPartecipanti > NUMSEDIE);

        // Creazione dei partecipanti
        Partecipante array[] = new Partecipante[numPartecipanti];

        for (int i = 0; i < numPartecipanti; i++) {
            array[i] = new Partecipante(sedie);
            logger.info("Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }

        scanner.close();
    }
}
