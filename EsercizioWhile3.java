import java.util.Scanner;

public class EsercizioWhile3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // chiedo all' utente di quale numero vuole la tabellina.
        System.out.print("Inserisci un numero: ");
        int numeroDaMoltiplicare = input.nextInt();
        // inizializzo il contatore che viene usato per contare i cicli e per
        // moltiplicare.
        int contatore = 1;

        while (contatore <= 10) {
            // qua avviene effettivamente la moltiplicazione
            int risultato = contatore * numeroDaMoltiplicare;
            // stampo l operazione
            System.out.println(contatore + " * " + numeroDaMoltiplicare + ": " + risultato);
            contatore++;
        }

        input.close();
    }
}
