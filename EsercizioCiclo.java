import java.util.Scanner;

public class EsercizioCiclo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // creo l'array.
        int[] array = { 0, 0, 0 };
        int contatore = 0;

        boolean controllo = true;
        while (controllo) {
            // creo il for per l inserimento dei dati.
            for (int i = 0; i < array.length; i++) {
                // chiedo inserimento dei dati.
                System.out.print("inserisci il numero: ");
                // inserisco l'input nell'array modificando il valore della cella
                int inserimentoUtente = input.nextInt();
                array[i] = inserimentoUtente;
            }
            for (int elemento : array) {
                // controllo che l elemento corrente sia superiore a 100, nel caso salta la
                // stampa.
                if (elemento >= 100) {
                    System.out.println(elemento);
                } else {
                    continue;
                }
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] >= 100 && contatore == 3) {
                    controllo = false;
                }
                contatore++;
            }
        }
        input.close();
    }
}
