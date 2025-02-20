import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFunzioni {

    // Creazione di variabili globali per gestire le penne per colore
    static ArrayList<String> rosso = new ArrayList<>();
    static ArrayList<String> blu = new ArrayList<>();
    static ArrayList<String> verde = new ArrayList<>();
    static ArrayList<String> nero = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean controllo = true;

        while (controllo) {

            // Menu di scelta
            System.out.println("Benvenuto." + "\n" +
                    "Scegli l'operazione che vuoi fare: " + "\n" +
                    "1. per aggiungere una penna." + "\n" +
                    "2. per visualizzare una spedizione." + "\n" +
                    "3. per contare le penne." + "\n" +
                    "4. per cercare le penne per colore.");

            int scelta = input.nextInt();
            input.nextLine(); // Pulisce

            switch (scelta) {
                case 1:
                    // Aggiungi una penna
                    while (controllo) {
                        System.out.println("Inserisci il colore della penna (rossa, blu, verde, nero):");
                        System.out.println("Se vuoi uscire inserisci si");
                        String penna = input.nextLine();
                        if (penna.equals("si")) {
                            break;
                        }
                        aggiungiPenna(penna);
                    }

                    break;

                case 2:
                    // Visualizza le penne per colore
                    VisualizzazioneSpedizione();
                    break;

                case 3:
                    // Conta le penne
                    System.out.println("Totale penne: " + contaDellePenne());
                    break;

                case 4:
                    // Cerca le penne per colore
                    System.out.println("Inserisci il colore della penna da cercare:");
                    String coloreCercato = input.nextLine();
                    cercaColore(coloreCercato);
                    break;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

            // Domanda se vuoi continuare
            System.out.println("Vuoi uscire? (si/no)");
            String scelta2 = input.nextLine();
            if (scelta2.equalsIgnoreCase("si")) {
                controllo = false;
            }
        }
        input.close();
    }

    // Metodo per aggiungere una penna alla spedizione
    public static void aggiungiPenna(String penna) {
        switch (penna) {
            case "rossa":
                rosso.add(penna);
                break;
            case "blu":
                blu.add(penna);
                break;
            case "verde":
                verde.add(penna);
                break;
            case "nero":
                nero.add(penna);
                break;
            default:
                System.out.println("Colore penna non valido!");
        }
    }

    // Metodo per visualizzare la spedizione
    public static void VisualizzazioneSpedizione() {
        System.out.println("Penne rosse: " + rosso);
        System.out.println("Penne blu: " + blu);
        System.out.println("Penne verdi: " + verde);
        System.out.println("Penne nere: " + nero);
    }

    // Metodo per contare le penne
    public static int contaDellePenne() {
        return rosso.size() + blu.size() + verde.size() + nero.size();
    }

    // Metodo per cercare le penne per colore
    public static void cercaColore(String colore) {
        switch (colore) {
            case "rossa":
                System.out.println("Penne rosse: " + rosso);
                break;
            case "blu":
                System.out.println("Penne blu: " + blu);
                break;
            case "verde":
                System.out.println("Penne verdi: " + verde);
                break;
            case "nero":
                System.out.println("Penne nere: " + nero);
                break;
            default:
                System.out.println("Colore non valido.");
        }
    }
}
