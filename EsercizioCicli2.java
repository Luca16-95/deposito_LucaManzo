import java.util.Scanner;

public class EsercizioCicli2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // il controllo per il while
        boolean controllo = true;
        int somma = 0;

        while (controllo) {
            // input utente con controllo numero se minore
            int numeroControllo = input.nextInt();
            if (numeroControllo < 0) {
                controllo = false;
                break;
            }
            // somma gli inserimenti ciclicamente
            somma = somma + numeroControllo;
            // controlla se pari
            if (somma % 2 == 0) {
                System.out.println("il numero è pari");
            } else {
                System.out.println("il numero è dispari");
            }
        }
        // chiusura scan.
        input.close();

    }
}
