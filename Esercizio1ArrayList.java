import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio1ArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // creo gli arrayList
        ArrayList<Integer> numeroPostiFile = new ArrayList<Integer>();
        ArrayList<Integer> numeroPostiColonne = new ArrayList<Integer>();
        ArrayList<String> nominativoUtente = new ArrayList<String>();
        // variabile utilizzata nel case1 per contare i posti.
        int postiDisponibili = 24;
        // utilizzato per finire il programma
        boolean controllo = true;
        while (controllo) {
            // print menù
            System.out.println(
                    "Ciao, clicca 1 per effettuare una prenotazione" + "\n"
                            + "clicca 2 per cercare la prenotazione" + "\n"
                            + "clicca 3 per controllare se ci sono posti disponibili");
            // variabile per lo switch
            int decisione = 0;
            decisione = input.nextInt();

            switch (decisione) {
                case 1:
                    // si occupa di far inserire le prenotazioni all'utente
                    while (true) {
                        // controllo se i posti sono disponibili, in caso contrario blocco l
                        // inserimento.
                        if (postiDisponibili == 0) {
                            System.out.println("non ci sono più posti disponibili");
                            break;
                        }

                        System.out.print("inserisci il numero della fila che vuoi occupare: ");
                        int numeroFilaScelto = input.nextInt();

                        if (numeroFilaScelto > 3) {
                            System.out.println("Posto inesistente!");
                        } else {
                            numeroPostiFile.add(numeroFilaScelto);
                        }
                        System.out.print("inserisci il numero della colonna: ");
                        int numeroColonnaScelto = input.nextInt();
                        if (numeroColonnaScelto > 8) {
                            System.out.println("La colonna non esiste!");
                        } else {
                            numeroPostiColonne.add(numeroColonnaScelto);
                        }
                        System.out.print("adesso dammi il tuo nominativo: ");
                        input.nextLine();
                        nominativoUtente.add(input.nextLine());

                        System.out.println("---------------");

                        System.out.println("Ho aggiunto: " + nominativoUtente + " alla fila: " + numeroPostiFile
                                + " e alla colonna: " + numeroPostiColonne);
                        // variabile che tiene traccia ad ogni inserimento.
                        postiDisponibili--;

                        System.out.println("Vuoi fare una nuova prenotazione? si/no");
                        String scelta1 = input.nextLine();
                        if (scelta1.equals("no")) {
                            System.out.println("Grazie mille,verrai riportato al menù principale!");
                            break;
                        }

                    }

                    break;
                case 2:
                    while (controllo) {
                        // si occupa di stampare il nominativo se presente
                        System.out.print("Dimmi che il nome della prenotazione: ");
                        input.nextLine();
                        String nomeCercato = input.nextLine();
                        boolean trovato = false;

                        for (int i = 0; i < nominativoUtente.size(); i++) {

                            if (nomeCercato.equals(nominativoUtente.get(i))) {
                                System.out.println("nominativo trovato: " + nominativoUtente.get(i));
                                trovato = true;
                                break;
                            }
                        }
                        if (!trovato) {
                            System.out.println("Nominativo non trovato.");
                        }

                        System.out.println("vuoi uscire? si/no");
                        String scelta = input.nextLine();
                        if (scelta.equals("si")) {
                            controllo = false;
                        }
                    }
                    break;

                case 3:

                    // stampa semplicemente i posti disponibili se presenti.
                    // Stampa le prenotazioni se presenti.
                    if (postiDisponibili != 0) {
                        System.out.println("i posti disponibili sono: " + postiDisponibili + "\n" + "sono presenti "
                                + nominativoUtente.size() + " prenotazioni.");
                    } else {
                        System.out.println("non ci sono posti disponibili");
                    }

                    break;

                default:
                    break;
            }

            System.out.println("vuoi uscire? si/no");
            String scelta = input.nextLine();
            if (scelta.equals("si")) {
                controllo = false;
            } else {
                // lo inizializzo nuovamente a true per essere sicuro che se la scelta sia no
                // la variabile abbia il valore che voglio
                controllo = true;
            }
        }
        input.close();
    }
}
