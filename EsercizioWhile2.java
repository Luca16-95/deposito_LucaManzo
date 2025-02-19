import java.util.Scanner;

public class EsercizioWhile2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // inizializzo la variabile da usare nel ciclo per contenere i numeri e
        // effettuare la somma.
        int sommaNumeri = 0;

        // uso l'input per controllare il ciclo e farlo terminare quando il valore di
        // numero utente vale 0.
        System.out.print("Inserisci il numero di volte che vuoi sommare i numeri: " + "\n"
                + "se il numero è negativo l'inserimento s'interrompe");
        int numeroUtente = input.nextInt();
        while (numeroUtente > 0) {
            // Prendo i numeri da tastiera per sommarli
            System.out.print("inserisci il numero da sommare: ");
            int numeroInserito = input.nextInt();
            // controllo se il numero inserito sia minore di 0
            if (numeroInserito < 0) {
                break;
            }
            // sommo i numeri
            sommaNumeri = sommaNumeri + numeroInserito;
            // decremento il numero inserito come contatore per portarlo a 0.
            numeroUtente--;

        }

        System.out.println("La somma dei numeri che hai inserito è: " + sommaNumeri);

        // chiudo lo scanner.
        input.close();
    }
}
