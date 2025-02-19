import java.util.Random;
import java.util.Scanner;

public class EsercizioWhile4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int numeroRandom = rand.nextInt(100);

        boolean controllo = true;

        while (controllo) {
            System.out.print("scegli il numero: ");
            int numeroScelto = input.nextInt();
            if (numeroScelto > numeroRandom) {
                System.out.println("Il numero che hai scelto è maggiore di quello che è uscito");
            } else if (numeroScelto == numeroRandom) {
                System.out.println("complimenti hai vinto!");
            } else if (numeroScelto < numeroRandom) {
                System.out.println("il numero che hai scelto è minore di quello uscito");
            }

            System.out.println("-------------");

            System.out.println("vuoi continuare? premi 1 per continuare o 0 per uscire");
            int sceltaFine = input.nextInt();
            if (sceltaFine == 0) {
                System.out.println("Grazie per aver giocato!");
                controllo = false;
            }

        }

        System.out.println("sei uscito dal gioco");

        input.close();
    }
}
