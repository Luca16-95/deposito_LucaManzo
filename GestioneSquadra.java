import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestioneSquadra {
    public static void main(String[] args) {

        Squadra napoli = new Squadra();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        // ciclo fino a quando il count non vale 11
        while (count < 11) {
            System.out.println("Inserisci il nome del giocatore:");
            String nome = controlloStringaNonVuota(scanner);
            System.out.println("Inserisci il ruolo del giocatore:");
            String ruolo = controlloStringaNonVuota(scanner);

            // Creazione di un nuovo giocatore e aggiunta alla squadra
            Giocatore giocatore = new Giocatore(nome, ruolo);
            napoli.aggiungiGiocatore(giocatore);

            count++; // Incrementa il contatore
        }

        // stampo tutti i calciatori presenti nell arrayList
        System.out.println("La squadra è formata da: \n\n");
        for (Giocatore giocatore : napoli.giocatori) {
            System.out.println(count + "." + " nome: " + giocatore.nome + ", gioca nel ruolo di: " + giocatore.ruolo);
        }

        scanner.close();
    }

    public static String controlloStringaNonVuota(Scanner scanner) {
        String input;

        while (true) {
            input = scanner.nextLine().trim(); // Rimuove gli spazi iniziali e finali

            // Controllo se la stringa è vuota
            if (input.isEmpty()) {
                System.out.println("Per favore, non lasciare lo spazio vuoto. Inserisci una stringa valida.");
                System.out.println("inserisci il dato richiesto: ");
                continue;
            }

            // Controllo se la stringa è un numero
            try {
                Integer.parseInt(input); // Provo a convertire la stringa in un numero
                System.out.println("Per favore, inserisci una stringa, non un numero.");
            } catch (NumberFormatException e) {
                // Se non è un numero, ritorna la stringa
                return input;
            }
        }
    }

}

// creo la classe calciatore.
class Giocatore {
    String nome;
    String ruolo;

    Giocatore(String nome, String ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
    }

}

// creo la squadra e ne faccio un arraylist.
class Squadra {
    List<Giocatore> giocatori;

    Squadra() {
        this.giocatori = new ArrayList<>();
    }

    public void aggiungiGiocatore(Giocatore giocatore) {
        giocatori.add(giocatore);
    }
}
