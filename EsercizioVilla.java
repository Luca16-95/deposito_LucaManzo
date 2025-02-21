import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioVilla {
    // Liste per memorizzare gli attributi delle ville
    static ArrayList<String> nomeVille = new ArrayList<String>();
    static ArrayList<Integer> stanze = new ArrayList<Integer>();
    static ArrayList<String> piscinaArr = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int scelta;
        do {
            System.out.println("\n1. Aggiungi villa");
            System.out.println("2. Visualizza ville");
            System.out.println("3. Cerca per nome");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiVilla();
                    break;
                case 2:
                    visualizzaVille();
                    break;
                case 3:
                    cercaVillaPerNome();
                    break;
                case 4:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        } while (scelta != 4);
    }

    public static void aggiungiVilla() {
        // raccolgo tutte informazioni delle ville e le metto ognuno nel proprio array.
        System.out.print("Inserisci il nome: ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("Inserisci il numero di stanze: ");
        int numeroStanze = input.nextInt();
        input.nextLine();// consumo l input di int.
        System.out.print("Inserisci \"si\" se ha una piscina o \"no\" se non la possiede: ");
        String piscina = input.nextLine();
        String inputSistemato = piscina.toLowerCase().trim();

        nomeVille.add(nome);
        stanze.add(numeroStanze);
        piscinaArr.add(inputSistemato);

        System.out.println("Villa aggiunta: " + nome + ", " + numeroStanze + ", " + inputSistemato);
    }

    public static void visualizzaVille() {
        if (nomeVille.isEmpty()) {
            System.out.println("Nessuna villa disponibile.");
        } else {
            for (int i = 0; i < nomeVille.size(); i++) {
                // lavoro sull'index per mandare in output.
                System.out.println("Nome: " + nomeVille.get(i) + ", N° Stanze: " + stanze.get(i) + ", Piscina: "
                        + piscinaArr.get(i));
            }
        }
    }

    // ricerca di ville per nome
    public static void cercaVillaPerNome() {
        input.nextLine();// pulisco l input dall'int
        String nomeScelto = input.nextLine();
        // for-each per la ricerca e stampa.
        for (String nomeVilla : nomeVille) {
            if (nomeVilla.equals(nomeScelto)) {
                System.out.println("La villa che cercavi: " + nomeVilla);
            } else if (nomeScelto.isEmpty()) {
                System.out.println("la villa che cercavi non esiste.");
            }
        }
    }
}
